import sbt.Project.projectToRef

lazy val commonSettings = Seq(
  version      := "1.0-SNAPSHOT",
  scalaVersion := "2.12.4",
  organization := "io.angelortega"
)


lazy val server = (project in file("server")).settings(commonSettings).settings(
  name := "interactive-data-visualization-server",

  scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  pipelineStages := Seq(digest, gzip),
  // triggers scalaJSPipeline when using compile or continuous compilation
  compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,

  libraryDependencies ++= Seq(
    "com.vmunier" %% "scalajs-scripts" % "1.1.1",
    "javax.xml.bind" % "jaxb-api" % "2.1",
    "org.webjars" % "requirejs" % "2.1.22",
    "org.webjars" % "jquery" % "2.1.4",
    "org.webjars" % "underscorejs" % "1.8.3",
    "org.webjars" % "nvd3" % "1.8.1",
    "org.webjars" % "d3js" % "3.5.6",
    "org.webjars" % "bootstrap" % "3.3.6",
    guice
  ),
  // Play Framework
  routesGenerator := InjectedRoutesGenerator)
  .enablePlugins(PlayScala)
  .aggregate(client)
  .dependsOn(sharedJvm)


lazy val client = (project in file("client"))
  .enablePlugins(ScalaJSPlugin, ScalaJSWeb)
  .dependsOn(sharedJs)
  .settings(commonSettings)
  .settings(
    name := "interactive-data-visualization-client",
    scalaJSUseMainModuleInitializer := true,
    scalaJSUseMainModuleInitializer in Test := false,

    libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.4"
  )
).enablePlugins(ScalaJSPlugin, ScalaJSWeb).
  dependsOn(sharedJs)


lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(commonSettings)
  .settings(name := "interactive-data-visualization-shared")
  .jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js


// loads the server project at sbt startup
onLoad in Global := (onLoad in Global).value andThen {s: State => "project server" :: s}
