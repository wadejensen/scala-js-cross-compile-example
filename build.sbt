import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport.scalaJSStage

enablePlugins(ScalaJSPlugin)

name := "realestate-optimiser"

scalaVersion in ThisBuild := "2.12.4"
val scalaIoVersion = "0.4.3"

resolvers += Resolver.sonatypeRepo("releases")

lazy val root = project.in(file(".")).
  aggregate(fooJS, fooJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val foo = crossProject.in(file(".")).
  settings(
    name := "foo",
    version := "0.1-SNAPSHOT",
    scalaJSUseMainModuleInitializer := true,
    scalaJSStage in ThisBuild := FastOptStage,
    scalaJSModuleKind := ModuleKind.CommonJSModule
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
    libraryDependencies ++= Seq(
      "io.scalajs" %%% "core" % scalaIoVersion,
      "io.scalajs" %%% "nodejs" % scalaIoVersion,
      "io.scalajs.npm" %%% "express" % scalaIoVersion
    )
  )

lazy val fooJVM = foo.jvm
lazy val fooJS = foo.js
