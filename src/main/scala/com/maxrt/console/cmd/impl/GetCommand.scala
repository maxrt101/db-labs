package com.maxrt.console.cmd.impl

import com.maxrt.db.{Model, Table}
import com.maxrt.console.Printer
import com.maxrt.console.cmd.{Command, Status}

/**
 * Implements getting records from the table
 * Able to get all records or a specific one by id
 */
class GetCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "get"

  def run(args: List[String]): Status = {
    if (args.length == 2) {
      Table.heplers.get(args(1)) match {
        case Some(helper) => {
          val values = helper.dao.getAll().map(_.asInstanceOf[helper.printer.ModelType])
          helper.printer.printAll(values)
        }
        case None => {
          println("No such table")
          return Status.FAIL
        }
      }
    } else if (args.length == 3) {
      Table.heplers.get(args(1)) match {
        case Some(helper) => {
          helper._1.get(args(2).toInt) match {
            case Some(value)  => helper.printer.print(value.asInstanceOf[helper.printer.ModelType])
            case None         => println("No such record"); return Status.FAIL
          }
        }
        case None => {
          println("No such table")
          return Status.FAIL
        }
      }
    } else {
      return Status.INVALID_ARGS
    }
    return Status.OK
  }
}
