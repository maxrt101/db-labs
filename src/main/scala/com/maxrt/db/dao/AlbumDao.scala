package com.maxrt.db.dao

import com.maxrt.db.{ConnectionInfo, PrimaryKey, Table}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Album
import com.maxrt.data.Reflection

class AlbumDao(implicit connInfo: ConnectionInfo) extends DaoImpl[Album](
  Reflection.findAnnotationOrDie[Album, Table].getName(),
  Reflection.findAnnotationOrDie[Album, PrimaryKey].getPrimaryKeyName(),
  () => new Album)
