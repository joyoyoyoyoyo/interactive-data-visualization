package io.angelortega.interactivedatavisualization.controllers

import javax.inject._

import io.angelortega.interactivedatavisualization.shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

}
