name := "learn-spark"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= {
  val sparkVer = "2.12.6"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources()
  )
}