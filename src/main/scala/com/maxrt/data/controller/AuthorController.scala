package com.maxrt.data.controller

import com.maxrt.db.model.Author
import com.maxrt.db.dao.AuthorDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class AuthorController extends ControllerImpl[Author](new AuthorDao(), new Printer[Author])
