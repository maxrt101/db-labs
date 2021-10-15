package com.maxrt.console.cmd

import com.maxrt.console.cmd.Status

/**
 * Trait that represents CLI Command
 */
trait Command {
  def check(cmdName: String): Boolean
  def run(args: List[String]): Status
}
