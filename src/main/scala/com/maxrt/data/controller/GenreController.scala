package com.maxrt.data.controller

import com.maxrt.db.ConnectionInfo
import com.maxrt.db.model.Genre
import com.maxrt.db.dao.GenreDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class GenreController(implicit connInfo: ConnectionInfo) extends ControllerImpl[Genre](new GenreDao()(connInfo), new Printer[Genre])
