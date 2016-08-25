organization in ThisBuild := "com.github.lavenderx"
scalaVersion in ThisBuild := "2.11.8"

val toolsStack = Seq(
  "com.github.pathikrit" %% "better-files" % "2.16.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "net.codingwell" %% "scala-guice" % "4.0.1"
)

val unitTestingStack = Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % Test
)

val commonDependencies = unitTestingStack ++ toolsStack

val akkaVersion = "2.4.9"
val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

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

  licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT"))),

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

  resolvers ++= Seq("repox" at "http://repox.gtan.com:8078/"),

  libraryDependencies ++= commonDependencies ++ akkaDependencies,

  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)
)

lazy val root = Project(id = "root", base = file("."))
  .settings(commonSettings: _*)
  .aggregate(core, akka)

lazy val core = Project(id = "core", base = file("core"))
  .settings(commonSettings)

lazy val akka = Project(id = "akka", base = file("akka"))
  .settings(commonSettings)
