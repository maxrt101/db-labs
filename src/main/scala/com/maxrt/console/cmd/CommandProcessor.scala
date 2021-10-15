package com.maxrt.console.cmd

import scala.io.StdIn.readLine
import util.control.Breaks._

import com.maxrt.console.cmd.Command

class CommandProcessor(commands: List[Command], prompt: String = ">") {

  def run(): Unit = {
    var running = true
    println("JDBC CLI")
    while (running) {
      breakable {
        print(prompt + " ")
        val input = readLine().split(' ')
        if (input.length < 1) {
          break
        }
        commands.find(cmd => cmd.check(input(0))) match {
          case Some(cmd) => cmd.run(input.toList)
          case None      => println("No such command found")
        } match {
          case Status.OK            => print("")
          case Status.EXIT          => running = false
          case Status.FAIL          => println("Command failed")
          case Status.INVALID_ARGS  => println("Invalid arguments for command '" + input(0) + "'")
        }
      }
    }
  }

}
