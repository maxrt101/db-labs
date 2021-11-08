package com.maxrt.data.controller

import com.maxrt.db.model.Song
import com.maxrt.db.dao.SongDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class SongController extends ControllerImpl[Song](new SongDao(), new Printer[Song])
