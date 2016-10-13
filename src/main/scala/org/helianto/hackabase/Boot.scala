package org.helianto.hackabase

import play.core.server.NettyServer

object Boot extends App {
  NettyServer.fromRouter() (HomeService.routes)
}

