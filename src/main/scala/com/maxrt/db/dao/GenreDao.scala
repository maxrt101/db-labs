package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table, ConnectionInfo}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Genre
import com.maxrt.data.Reflection

class GenreDao(implicit connInfo: ConnectionInfo) extends DaoImpl[Genre](
  Reflection.findAnnotationOrDie[Genre, Table].getName(),
  Reflection.findAnnotationOrDie[Genre, PrimaryKey].getPrimaryKeyName(),
  () => new Genre)
