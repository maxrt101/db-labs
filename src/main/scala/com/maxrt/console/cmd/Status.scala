package com.maxrt.console.cmd

enum Status {
  case OK;              // Command executed OK
  case FAIL;            // Command execution failed
  case EXIT;            // Signals exit to the shell
  case INVALID_ARGS;    // Signals that invalid arguments were passed to the command
  case NO_SUCH_TABLE;   // Signals the absence of table with requested name in the database
  case NO_SUCH_RECORD;  // Signals the absence of requested record in the table
}
