package com.maxrt.data.controller

import com.maxrt.db.model.Genre
import com.maxrt.db.dao.GenreDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class GenreController extends ControllerImpl[Genre](new GenreDao(), new Printer[Genre])
