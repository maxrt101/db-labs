package com.maxrt.db.dao

import com.maxrt.db.Table
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.SavedSong
import com.maxrt.data.Reflection

class SavedSongDao extends DaoImpl[SavedSong](Reflection.findAnnotationOrDie[SavedSong, Table].getName(), () => new SavedSong)

