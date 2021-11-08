package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.Command
import com.maxrt.data.Controller

/**
 * Implements getting records from the table
 * Able to get all records or a specific one by id
 */
class GetCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "get"

  def run(args: List[String]): Unit = {
    if (args.length == 2) {
      Controller.controllers.get(args(1)) match {
        case Some(controller) => controller.getAll()
        case _ => return
      }
    } else if (args.length == 3) {
      Controller.controllers.get(args(1)) match {
        case Some(controller) => controller.get(args(2).toInt)
        case _ => return
      }
    } else {
      println("Usage: get TABLE [ID]")
    }
  }
}
