package com.maxrt.console.cmd.impl

import com.maxrt.db.Table
import com.maxrt.console.cmd.{Command, Status}

class ListCommand extends Command {

  def check(cmdName: String): Boolean = cmdName == "list"

  def run(args: List[String]): Status = {
    if (args.length == 1) {
      Table.tables.foreach(println)
    } else {
      return Status.INVALID_ARGS
    }
    return Status.OK
  }

}
