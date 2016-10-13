package org.helianto.hackabase.domain

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID

case class Project (_id: Option[BSONObjectID], entityId: String, projectName: String, projectDesc: String)

object Project {
  val collectionName = "project"
  implicit val formatter = Json.format[Project]
}