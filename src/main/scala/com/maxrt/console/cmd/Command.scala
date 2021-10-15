package com.maxrt.console.cmd

import com.maxrt.console.cmd.Status

trait Command {
  def check(cmdName: String): Boolean
  def run(args: List[String]): Status
}
