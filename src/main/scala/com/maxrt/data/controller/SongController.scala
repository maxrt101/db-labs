package com.maxrt.data.controller

import com.maxrt.db.ConnectionInfo
import com.maxrt.db.model.Song
import com.maxrt.db.dao.SongDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class SongController(implicit connInfo: ConnectionInfo) extends ControllerImpl[Song](new SongDao()(connInfo), new Printer[Song])
