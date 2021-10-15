package com.maxrt.console

import sys.process._

object Console {
  val clearCommand: String = if System.getProperty("os.name").startsWith(("Windows")) then "cls" else "clear"

  def clear(): Unit = clearCommand.!

}
