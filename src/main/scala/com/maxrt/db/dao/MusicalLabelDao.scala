package com.maxrt.db.dao

import com.maxrt.db.PrimaryKey
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.MusicalLabel
import com.maxrt.data.Reflection

class MusicalLabelDao extends DaoImpl[MusicalLabel](
  Reflection.findAnnotationOrDie[MusicalLabel, PrimaryKey].getPrimaryKeyName(),
  () => new MusicalLabel)
