package com.maxrt.data.controller

import com.maxrt.db.model.User
import com.maxrt.db.dao.UserDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class UserController extends ControllerImpl[User](new UserDao(), new Printer[User])
