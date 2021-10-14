package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Album
import com.maxrt.data.Reflection

class AlbumDao extends DaoImpl[Album](
  Reflection.findAnnotationOrDie[Album, Table].getName(),
  Reflection.findAnnotationOrDie[Album, PrimaryKey].getPrimaryKeyName(),
  () => new Album)
