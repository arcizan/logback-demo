package logbackdemo

import ch.qos.logback.classic.spi.{ILoggingEvent, ThrowableProxy}
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply

class CustomFilter extends Filter[ILoggingEvent] {
  override def decide(e: ILoggingEvent): FilterReply =
    e.getThrowableProxy match {
      case null => FilterReply.NEUTRAL
      case tp => tp.asInstanceOf[ThrowableProxy].getThrowable match {
        case t: SampleException3 => FilterReply.DENY
        case _ => FilterReply.NEUTRAL
      }
    }
}
