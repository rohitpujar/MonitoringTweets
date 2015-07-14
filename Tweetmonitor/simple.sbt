name := "Simple Project"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.spark"  % "spark-core_2.10"              % "1.3.0",
  "org.apache.spark"  % "spark-mllib_2.10"             % "1.3.0"
  )

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"
fork := true
