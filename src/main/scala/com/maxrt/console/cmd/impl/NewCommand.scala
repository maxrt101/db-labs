package com.maxrt.console.cmd.impl

import scala.io.StdIn.readLine

import com.maxrt.db.{Model, Table}
import com.maxrt.console.Printer
import com.maxrt.console.cmd.{Command, Status}
import com.maxrt.data.Reflection

/**
 * Implements record creation
 * Interactive - needs user input
 */
class NewCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "new"

  def run(args: List[String]): Status = {
    if (args.length == 2) {
      val helper = Table.heplers.get(args(1)) match {
        case Some(helper) => helper
        case None => return Status.NO_SUCH_TABLE
      }

      val value = helper.dao.newModelInstance()

      val fields = Reflection.getFields[helper.dao.ModelType](helper.dao.getModelClassTag())

      for (i <- 0 until fields.length) {
        print(s"${fields(i).getName}: ")
        val input = readLine()
        if (input.length > 0) {
          value.setField(fields(i).getName(), if fields(i).getType.toString == "int" then input.toInt.asInstanceOf[AnyRef] else input)
        }
      }

      helper.dao.save(value)
    } else {
      return Status.INVALID_ARGS
    }
    return Status.OK
  }
}
