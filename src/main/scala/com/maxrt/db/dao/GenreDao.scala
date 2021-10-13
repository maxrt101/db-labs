package com.maxrt.db.dao

import com.maxrt.db.Table
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Genre
import com.maxrt.data.Reflection

class GenreDao extends DaoImpl[Genre](Reflection.findAnnotationOrDie[Genre, Table].getName(), () => new Genre)
