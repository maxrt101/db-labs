package com.maxrt.console.cmd

import scala.io.StdIn.readLine
import util.control.Breaks._

import com.maxrt.console.cmd.Command

/**
 * Handles user input & Commands
 * Basically a shell (which is a command procesor)
 */
class CommandProcessor(commands: List[Command], prompt: String = ">") {
  def run(): Unit = {
    var running = true
    println("JDBC CLI\nType `help` for help")
    while (running) {
      breakable {
        print(prompt + " ")
        val input = readLine().split(' ')
        if (input.length < 1) {
          break
        }
        commands.find(cmd => cmd.check(input(0))) match {
          case Some(cmd) => try {
            cmd.run(input.toList)
          } catch {
            case e => {
              println("Exception was caught during '" + input.reduceRight((a, b) => s"$a $b") + "' command execution:")
              e.printStackTrace()
            }
          }
          case _ => println("No such command found")
        } match {
          case Status.EXIT            => running = false
          case Status.FAIL            => println("Command failed")
          case Status.INVALID_ARGS    => println("Invalid arguments for command '" + input(0) + "'")
          case Status.NO_SUCH_RECORD  => println("No such record")
          case Status.NO_SUCH_TABLE   => println("No such table")
          case _                      => print("")
        }
      }
    }
  }

}
