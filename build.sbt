lazy val root =
  Project("taro", file("."))
    .settings(scalaVersion := "2.12.8")
    .aggregate(data, instances)

lazy val data =
  project
    .in(file("taro-data"))
    .settings(scalaVersion := "2.12.8")
    .settings(libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.15.0")
    .settings(scalacOptions in (Compile, doc) ++= Seq("-diagrams"))
    .settings(addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full))

lazy val instances =
  project
    .in(file("taro-instances"))
    .settings(scalaVersion := "2.12.8")
    .dependsOn(data)