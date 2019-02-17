import Common._
import Dependencies._

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.9")

lazy val root =
  (project in file(".")).commonSettings.scalafmtSettings.dockerSettings //.coverageSettings
    .enablePlugins(AshScriptPlugin)
    .settings(
      name := "image-store-service",
      libraryDependencies ++= fs2 ++ http4s ++ monix ++ cats ++ awsS3 ++ pureConfig ++ scalaTest
    )
