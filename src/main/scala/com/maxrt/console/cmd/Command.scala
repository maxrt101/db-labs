package com.maxrt.console.cmd

/**
 * Trait that represents CLI Command
 */
trait Command {
  def check(cmdName: String): Boolean
  def run(args: List[String]): Unit
}
