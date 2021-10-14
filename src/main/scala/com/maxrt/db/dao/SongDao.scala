package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Song
import com.maxrt.data.Reflection

class SongDao extends DaoImpl[Song](
  Reflection.findAnnotationOrDie[Song, Table].getName(),
  Reflection.findAnnotationOrDie[Song, PrimaryKey].getPrimaryKeyName(),
  () => new Song)
