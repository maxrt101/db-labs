package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.Command
import com.maxrt.data.Controller

/**
 * Implements record creation
 * Interactive - needs user input
 */
class NewCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "new"

  def run(args: List[String]): Unit = {
    if (args.length == 2) {
      Controller.controllers.get(args(1)) match {
        case Some(controller) => controller.create()
        case _ => return
      }
    } else {
      println("Usage: new TABLE")
    }
  }
}
