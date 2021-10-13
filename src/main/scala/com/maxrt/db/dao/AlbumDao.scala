package com.maxrt.db.dao

import com.maxrt.db.Table
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Album
import com.maxrt.data.Reflection

class AlbumDao extends DaoImpl[Album](Reflection.findAnnotationOrDie[Album, Table].getName(), () => new Album)
