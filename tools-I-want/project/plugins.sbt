// Paul Snively recommends:
// https://www.reddit.com/r/scala/comments/dlo3d7/can_i_disable_silent_typecasting/f4sk6ib/

addSbtPlugin( "org.wartremover" % "sbt-wartremover" % "2.4.2" )
  // https://repo1.maven.org/maven2/org/wartremover/wartremover_2.11/
  // Latest versions:
  // Scala 2.11 -> 2.4.2
  // Scala 2.10 -> 2.3.7
// addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.8")
  // https://dl.bintray.com/sbt/sbt-plugin-releases/io.github.davidgregory084/sbt-tpolecat/scala_2.10
  // Maybe available for Scala 2.10, 2.12:

