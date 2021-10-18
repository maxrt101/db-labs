package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table, ConnectionInfo}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Song
import com.maxrt.data.Reflection

class SongDao(implicit connInfo: ConnectionInfo) extends DaoImpl[Song](
  Reflection.findAnnotationOrDie[Song, Table].getName(),
  Reflection.findAnnotationOrDie[Song, PrimaryKey].getPrimaryKeyName(),
  () => new Song)
