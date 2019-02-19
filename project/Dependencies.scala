import sbt._

object Dependencies {

  object Version {
    val fs2 = "1.0.3"
    val http4s = "0.19.0"
    val monix = "3.0.0-RC2"
    val cats = "1.6.0"
    val awsS3 = "0.2.2"
    val pureConfig = "0.9.0"
    val scalaTest = "3.0.5"
  }

  val fs2 = Seq(
    "co.fs2" %% "fs2-core" % Version.fs2,
    "co.fs2" %% "fs2-io" % Version.fs2,
    "co.fs2" %% "fs2-reactive-streams" % Version.fs2
  )

  val http4s = Seq(
    "org.http4s" %% "http4s-blaze-server" % Version.http4s,
    "org.http4s" %% "http4s-circe" % Version.http4s,
    "org.http4s" %% "http4s-dsl" % Version.http4s
  )

  val monix = Seq("io.monix" %% "monix" % Version.monix)

  val cats = Seq("org.typelevel" %% "cats-core" % Version.cats)

  val awsS3 = Seq("com.github.wirthan" %% "s3dsl" % Version.awsS3)

  val pureConfig = Seq("com.github.pureconfig" %% "pureconfig" % Version.pureConfig)

  val scalaTest = Seq("org.scalatest" %% "scalatest" % Version.scalaTest % Test)
}
