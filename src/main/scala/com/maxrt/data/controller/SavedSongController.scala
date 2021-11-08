package com.maxrt.data.controller

import com.maxrt.db.model.SavedSong
import com.maxrt.db.dao.SavedSongDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class SavedSongController extends ControllerImpl[SavedSong](new SavedSongDao(), new Printer[SavedSong])
