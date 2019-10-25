// PITFALL: .sbt syntax is not exactly Scala syntax

// mandatory
scalaVersion := "2.13.1"

// dependencies
  // use Scaladex, an index of Scala libraries, to find more
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
