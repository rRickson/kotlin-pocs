package com.github.rrickson.kotlinpocs.controllers

import com.github.rrickson.kotlinpocs.model.User
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext

class UserController {

  fun getUser(ctx: RoutingContext) {
    // Simulating fetching a user
    val userId = ctx.request().getParam("id")
    if (userId != null) {
      val user = User(userId.toInt(), "User Name $userId")
      val json = JsonObject()
      json.put("id", user.id)
      json.put("name", user.name)

      ctx.response()
        .putHeader("Content-Type", "application/json")
        .end(json.encode())
    } else {
      ctx.response()
        .setStatusCode(400)
        .putHeader("Content-Type", "application/json")
        .end(JsonObject().put("error", "testing error").encode())
    }
  }
  fun createUser(ctx: RoutingContext) {
    val body = ctx.bodyAsJson
    val name = body.getString("name")
    if (name != null) {
      val user = User((Math.random() * 1000).toInt(), name)
      val json = JsonObject()
      json.put("id", user.id)
      json.put("name", user.name)
      ctx.response()
        .putHeader("Content-Type", "application/json")
        .setStatusCode(201)
        .end(json.encode())
    } else {
      ctx.response()
        .setStatusCode(400)
        .putHeader("Content-Type", "application/json")
        .end(JsonObject().put("error", "Naming").encode())
    }
  }
}
