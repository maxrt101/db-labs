package com.maxrt.data.controller

import com.maxrt.db.model.Album
import com.maxrt.db.dao.AlbumDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class AlbumController extends ControllerImpl[Album](new AlbumDao(), new Printer[Album]())
