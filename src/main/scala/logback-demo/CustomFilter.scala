package logbackdemo

import ch.qos.logback.classic.spi.{ILoggingEvent, ThrowableProxy}
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply

class CustomFilter extends Filter[ILoggingEvent] {
  override def decide(e: ILoggingEvent): FilterReply =
    if (excludeExceptionType(e))
      FilterReply.DENY
    else
      FilterReply.NEUTRAL

  private def excludeExceptionType(e: ILoggingEvent): Boolean =
    Option(e.getThrowableProxy).exists {
      case tp: ThrowableProxy => tp.getThrowable.isInstanceOf[SampleException3]
      case _ => false
    }
}
