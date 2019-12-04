name := "logback-demo"
version := "1.0"
scalaVersion := "2.13.1"
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.8",
  "org.codehaus.janino" % "janino" % "3.1.0",
  "org.slf4j" % "slf4j-api" % "1.7.22",
  "org.slf4j" % "slf4j-ext" % "1.7.22"
)
