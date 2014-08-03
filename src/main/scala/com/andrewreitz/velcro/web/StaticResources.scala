package com.andrewreitz.velcro.web

import spray.http.StatusCodes
import spray.routing.HttpService

trait StaticResources extends HttpService {
  val staticResources = get {
    path("") {
      redirect("/index.html", StatusCodes.MovedPermanently)
    } ~
    path("favicon.ico") {
      redirect("images/favicon.ico", StatusCodes.MovedPermanently)
    } ~
    path(Rest) {
      path => getFromResource("www/%s" format path)
    }
  }
}
