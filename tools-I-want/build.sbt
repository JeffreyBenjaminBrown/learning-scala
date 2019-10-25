lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.5"
    )),
    name := "scalatest-example"
  )

resolvers ++= Seq(
  // for Saddle, Breeze
  // https://saddle.github.io/doc/index.html#download-and-install
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scala-saddle" %% "saddle-core" % "1.3.+",
    // https://repo1.maven.org/maven2/org/scala-saddle/saddle-core_2.12/maven-metadata.xml
    // only available for Scala 2.9 through 2.11
  "org.scalanlp" %% "breeze" % "1.0",
  "org.scalanlp" %% "breeze-viz" % "1.0",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)
