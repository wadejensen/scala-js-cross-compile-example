import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport.scalaJSStage

enablePlugins(ScalaJSPlugin)

name := "Foo root project"

scalaVersion in ThisBuild := "2.12.4"

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
    scalaJSStage in ThisBuild := FastOptStage
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val fooJVM = foo.jvm
lazy val fooJS = foo.js
