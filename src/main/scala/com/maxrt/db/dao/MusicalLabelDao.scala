package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table, ConnectionInfo}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.MusicalLabel
import com.maxrt.data.Reflection

class MusicalLabelDao(implicit connInfo: ConnectionInfo) extends DaoImpl[MusicalLabel](
  Reflection.findAnnotationOrDie[MusicalLabel, Table].getName(),
  Reflection.findAnnotationOrDie[MusicalLabel, PrimaryKey].getPrimaryKeyName(),
  () => new MusicalLabel)
