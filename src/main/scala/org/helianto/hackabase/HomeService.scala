package org.helianto.hackabase

import akka.actor.ActorSystem
import org.helianto.hackabase.domain.Project
import play.api.libs.json._
import play.api.mvc._
import play.api.routing.sird._

import scala.concurrent.ExecutionContextExecutor

object HomeService {

  implicit val system: ActorSystem = ActorSystem("hackabase")
  implicit def executor: ExecutionContextExecutor = system.dispatcher

  val routes: PartialFunction[RequestHeader, Action[JsValue]] = {
    case POST(p"/sendConfirmation") => Action(BodyParsers.parse.json) { request =>
      request.body.validate[Project] match {
        case s: JsSuccess[Project] =>
          // TODO
          Results.Ok(s"Successfuly sent!")
        case e: JsError => Results.InternalServerError
      }
    }
  }


}