package org.helianto.hackabase.domain

import java.util.Date

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID

case class Team (_id: Option[BSONObjectID], identityId: String, identityName: String, joined: Date, imageUrl: String, currentRole: String)

object Team {
  val collectionName = "team"
  implicit val formatter = Json.format[Team]
}