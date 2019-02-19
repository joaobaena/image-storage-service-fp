package com.github.joaobaena.file_store.external.routes

import cats.effect.Sync
import cats.implicits._
import fs2.Stream
import org.http4s._
import org.http4s.dsl.Http4sDsl
import org.http4s.multipart.Part

class FileUploadRoutes[F[_]](fileService: FileService[F])(implicit F: Sync[F]) extends Http4sDsl[F] {
  val service: HttpRoutes[F] =
    HttpRoutes.of[F] {
      case req @ POST -> Root / "image-storage-service" / "api" / "upload-photo" =>
        req.decodeWith(multipart[F], strict = true) { response =>
          val stream = response.parts.traverse(fileService.store)

          Ok(stream.map(_ => s"File uploaded ${response.parts}"))
        }
    }

}

trait FileService[F[_]] {
  def store(part: Part[F]): Stream[F, Unit]
}
