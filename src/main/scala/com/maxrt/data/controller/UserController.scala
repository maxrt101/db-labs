package com.maxrt.data.controller

import com.maxrt.db.ConnectionInfo
import com.maxrt.db.model.User
import com.maxrt.db.dao.UserDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class UserController(implicit connInfo: ConnectionInfo) extends ControllerImpl[User](new UserDao()(connInfo), new Printer[User])
