package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.{Command, Status}

class HelpCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "help"

  def run(args: List[String]): Status = {
    if (args.length == 1) {
      println("JDBC Cosole Connector\nAvailable commands: exit. help, list, get, update, new, delete\nHelp usage: help [COMMAND]")
    } else if (args.length == 2) {
      args(1) match {
        case "exit"   => println("Exits the shell\nUsage: exit")
        case "help"   => println("Gets help\nUsage: help [COMMAND]")
        case "list"   => println("Lists all tables\nUsage: list")
        case "get"    => println("Gets data from the table\nUsage: get TABLE [ID]")
        case "update" => println("Updates the record\nUsage: update TABLE ID FIELD...")
        case "new"    => println("Creates new record\nUsage: new TABLE FIELD...")
        case "delete" => println("Deletes the record\nUsage: delete TABLE ID")
        case _        => println("Unknown command")
      }
    } else {
      return Status.INVALID_ARGS
    }
    return Status.OK
  }
}
