lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.10"
    )),
    name := "tools-I-want"
  )

resolvers ++= Seq(
  // for Breeze
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases"  at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "io.github.pityka" %% "saddle-core-fork" % "1.3.4-fork1",
    // PITFALL:
      // The Saddle docs suggest this:
      // "org.scala-saddle" %% "saddle-core" % "1.3.+",
      // but that repo is abandoned,
      // and only available for Scala 2.9 through 2.11.
    // The fork: https://github.com/pityka/saddle
    // The issue that led me to this config
      // https://github.com/saddle/saddle/issues/84
  "org.scalanlp" %% "breeze" % "1.0",
  "org.scalanlp" %% "breeze-viz" % "1.0",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

// for the WartRemover compiler plugin -- see project/plugins.sbt
// wartremoverErrors ++= Warts.unsafe
  // PITFALL: Cannot execute
  // val file = org.saddle.io.CsvFile("data/test.csv")
  // because it uses null.
// wartremoverErrors -= Wart.NonUnitStatements
  // disable to permit variable assignment in the repl
