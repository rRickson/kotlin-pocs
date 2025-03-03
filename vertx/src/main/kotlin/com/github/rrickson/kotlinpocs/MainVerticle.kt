package com.github.rrickson.kotlinpocs

import com.github.rrickson.kotlinpocs.controllers.UserController
import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    val router = Router.router(vertx)
    val userController = UserController()

    router.get("/").handler { ctx ->
      ctx.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x with Kotlin!")
    }
    router.get("/user/:id").handler(userController::getUser)
    router.post("/user").handler(userController::createUser)

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen(8888).onComplete { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause());
        }
      }
  }
}

