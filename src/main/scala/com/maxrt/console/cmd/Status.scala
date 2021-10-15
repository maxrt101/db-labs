package com.maxrt.console.cmd

enum Status {
  case OK;            // Command executed OK
  case FAIL;          // Command execution failed
  case EXIT;          // Signals exit to the shell
  case INVALID_ARGS;  // Signals that invalid arguments were passed to the command
}
