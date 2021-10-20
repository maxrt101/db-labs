package com.maxrt.data.controller

import com.maxrt.db.ConnectionInfo
import com.maxrt.db.model.SavedSong
import com.maxrt.db.dao.SavedSongDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class SavedSongController(implicit connInfo: ConnectionInfo) extends ControllerImpl[SavedSong](new SavedSongDao()(connInfo), new Printer[SavedSong])
