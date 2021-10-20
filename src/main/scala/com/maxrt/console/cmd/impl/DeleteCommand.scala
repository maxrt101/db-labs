package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.Command
import com.maxrt.data.Controller

/**
 * Implements deleting of the record
 */
class DeleteCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "delete"

  def run(args: List[String]): Unit = {
    if (args.length == 3) {
      Controller.controllers.get(args(1)) match {
        case Some(controller) => controller.delete(args(2).toInt)
        case _ => return
      }
    } else {
      println("Usage: delete TABLE ID")
    }
  }
}
