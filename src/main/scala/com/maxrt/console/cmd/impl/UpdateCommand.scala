package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.Command
import com.maxrt.data.Controller

/**
 * Implements record updating
 * Interactive - needs user input
 */
class UpdateCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "update"

  def run(args: List[String]): Unit = {
    if (args.length == 3) {
      Controller.controllers.get(args(1)) match {
        case Some(controller) => controller.update(args(2).toInt)
        case _ => return
      }
    } else {
      println("Usage: update TABLE ID")
    }
  }
}
