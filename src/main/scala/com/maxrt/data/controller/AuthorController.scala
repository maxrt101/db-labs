package com.maxrt.data.controller

import com.maxrt.db.ConnectionInfo
import com.maxrt.db.model.Author
import com.maxrt.db.dao.AuthorDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class AuthorController(implicit connInfo: ConnectionInfo) extends ControllerImpl[Author](new AuthorDao()(connInfo), new Printer[Author])
