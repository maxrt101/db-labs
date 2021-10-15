package com.maxrt.console.cmd.impl

import com.maxrt.console.cmd.{Command, Status}

class ExitCommand extends Command {
  def check(cmdName: String): Boolean = cmdName == "exit"

  def run(args: List[String]): Status = {
    for (a <- 1 until args.length) {
      print(args(a) + " ")
    }
    println()
    return Status.EXIT
  }
}
