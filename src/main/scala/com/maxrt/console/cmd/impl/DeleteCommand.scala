package com.maxrt.console.cmd.impl

import com.maxrt.db.{Model, Table}
import com.maxrt.console.Printer
import com.maxrt.console.cmd.{Command, Status}
import com.maxrt.data.Reflection

/**
 * Implements deleting of the record
 */
class DeleteCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "delete"

  def run(args: List[String]): Status = {
    if (args.length == 3) {
      val helper = Table.heplers.get(args(1)) match {
        case Some(helper) => helper
        case None => return Status.NO_SUCH_TABLE
      }

      val value = helper.dao.get(args(2).toInt) match {
        case Some(value) => value
        case None => return Status.NO_SUCH_RECORD
      }
      helper.dao.delete(value)
    } else {
      return Status.INVALID_ARGS
    }
    return Status.OK
  }
}
