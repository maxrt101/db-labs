package com.maxrt.console.cmd.impl

//import com.maxrt.db.Table
import com.maxrt.console.cmd.Command

class ListCommand extends Command {
  private val tables = List("album", "author", "genre", "musical_label", "saved_song", "song", "user")

  def check(cmdName: String): Boolean = cmdName == "list"

  def run(args: List[String]): Unit = {
    if (args.length == 1) {
      tables.foreach(println)
    } else {
      println("Usage: list")
    }
  }

}
