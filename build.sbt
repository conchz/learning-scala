import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

import scalariform.formatter.preferences._

val commonsLang3 = "org.apache.commons" % "commons-lang3" % "3.4"
val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.1.7"
val toolsStack = Seq(commonsLang3, logbackClassic)

val scalatest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
val unitTestingStack = Seq(scalatest)

val commonDependencies = unitTestingStack ++ toolsStack

lazy val commonSettings = Seq(
  organization := "com.github.lavenderx",
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
    "scm:git:git@github.com:lavenderx/learning-scala.git",
    Some("scm:git:git@github.com:lavenderx/learning-scala.git"))
  ),

  licenses := Seq(
    ("MIT", url("https://opensource.org/licenses/MIT"))
  ),

  scalaVersion := "2.11.8",

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-unchecked"
  ),

  javacOptions ++= Seq(
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked"
  ),

  ivyScala := ivyScala.value map {
    _.copy(overrideScalaVersion = true)
  },

  libraryDependencies ++= commonDependencies
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
  .settings(
    unmanagedSourceDirectories in Compile <<= baseDirectory { base =>
      Seq(
        base / "src/main/scala"
      )
    },

    unmanagedSourceDirectories in Test <<= baseDirectory { base =>
      Seq(
        base / "src/test/scala"
      )
    }
  )