package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.Command

/**
 * Shows help
 */
class HelpCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "help"

  def run(args: List[String]): Unit = {
    if (args.length == 1) {
      println("JDBC Cosole Connector\nAvailable commands: exit. help, list, get, update, new, delete\nHelp usage: help [COMMAND]")
    } else if (args.length == 2) {
      args(1) match { // TODO get help strings from Command objects
        case "exit"   => println("Exits the shell\nUsage: exit")
        case "help"   => println("Gets help\nUsage: help [COMMAND]")
        case "list"   => println("Lists all tables\nUsage: list")
        case "get"    => println("Gets data from the table\nUsage: get TABLE [ID]")
        case "update" => println("Updates the record\nUsage: update TABLE ID")
        case "new"    => println("Creates new record\nUsage: new TABLE")
        case "delete" => println("Deletes the record\nUsage: delete TABLE ID")
        case _        => println("Unknown command")
      }
    } else {
      println("Usage: help [COMMAND]")
    }
  }
}
