package com.maxrt.console.cmd.impl

import com.maxrt.db.Table
import com.maxrt.console.cmd.Command

class ListCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "list"

  def run(args: List[String]): Unit = {
    if (args.length == 1) {
      Table.tables.foreach(println)
    } else {
      println("Usage: list")
    }
  }

}
