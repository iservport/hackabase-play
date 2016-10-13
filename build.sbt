
organization := "org.helianto"

lazy val root = (project in file("."))
  .enablePlugins(JavaServerAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    name := "hackabase",
    version := "1.0.2.RELEASE",
    mainClass in (Compile) := Some("com.iservport.hackabase.Boot"),
    dockerBaseImage := "azul/zulu-openjdk:8",
    dockerUpdateLatest := true,
    dockerExposedPorts := Seq(9000),
    dockerExposedVolumes := Seq("/opt/data"),
    dockerRepository := Some("iservport"),
    libraryDependencies ++= Seq(
      "com.typesafe.play"  %% "play-netty-server" % "2.5.1",
      "com.typesafe.akka"  %% "akka-slf4j"   % "2.4.1",
      "com.typesafe.akka"  %% "akka-http-experimental" % "2.0.1",
      "org.reactivemongo"  %% "play2-reactivemongo" % "0.11.14",
      "com.typesafe"        % "config" % "1.3.0",
      "com.typesafe.akka"  %% "akka-testkit"      % "2.4.1"   % "test",
      "org.scalatest"      %% "scalatest"         % "3.0.0"   % "test",
      "org.mockito"         % "mockito-all"       % "1.10.19" % "test",
      "org.slf4j" % "slf4j-simple" % "1.7.14"
    )
  )

scalaVersion := "2.11.8"

sbtVersion := "0.13.9"


licenses in ThisBuild := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
