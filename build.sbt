import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

import scalariform.formatter.preferences._

val betterFiles = "com.github.pathikrit" %% "better-files" % "2.16.0"
val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.1.7"
val toolsStack = Seq(betterFiles, logbackClassic)

val scalatest = "org.scalatest" %% "scalatest" % "2.2.6" % Test
val unitTestingStack = Seq(scalatest)

val commonDependencies = unitTestingStack ++ toolsStack

organization in ThisBuild := "com.github.lavenderx"
scalaVersion in ThisBuild := "2.11.8"

lazy val commonSettings = Seq(
  name := "learning-scala",
  version := "1.0",
  homepage := Some(url("https://github.com/lavenderx/learning-scala")),

  developers := List(Developer(
    "lavenderx",
    "Zongzhi Bai",
    "dolphineor@gmail.com",
    url("https://github.com/lavenderx"))
  ),

  scmInfo := Some(ScmInfo(
    url("https://github.com/lavenderx/learning-scala"),
    "scm:git:git@github.com:lavenderx/learning-scala.git")
  ),

  licenses := Seq(
    ("MIT", url("https://opensource.org/licenses/MIT"))
  ),

  fork in run := true,

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation"
  ),

  javacOptions in compile ++= Seq(
    "-encoding", "UTF-8",
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),

  ivyScala := ivyScala.value map {
    _.copy(overrideScalaVersion = true)
  },

  resolvers ++= Seq(
    "repox" at "http://repox.gtan.com:8078/"
  ),

  libraryDependencies ++= commonDependencies
    ++ Seq("net.codingwell" %% "scala-guice" % "4.0.1"),

  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(core)

lazy val core: Project = (project in file("core"))
  .enablePlugins(SbtScalariform)
  .settings(SbtScalariform.defaultScalariformSettings ++ Seq(
    ScalariformKeys.preferences := ScalariformKeys.preferences.value
      .setPreference(FormatXml, false)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(DanglingCloseParenthesis, Force)
  ))
  .settings(commonSettings)