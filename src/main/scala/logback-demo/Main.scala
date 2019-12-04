package logbackdemo

import org.slf4j.{Logger, LoggerFactory}

object Main extends App {
  val logger = LoggerFactory.getLogger(this.getClass)
  logger.info("Hello")
  logger.warn("Hi")
  logger.error("SampleException1 occured", SampleException1())
  logger.error("SampleException2 occured", SampleException2())
  logger.error("SampleException3 occured", SampleException3())
  logger.info("Bye")
}

case class SampleException1(msg: String = "Failed to xxx") extends RuntimeException(msg)
case class SampleException2(msg: String = "Failed to yyy") extends RuntimeException(msg)
case class SampleException3(msg: String = "Failed to zzz") extends RuntimeException(msg)
