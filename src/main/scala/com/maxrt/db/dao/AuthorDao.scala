package com.maxrt.db.dao

import com.maxrt.db.Table
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.Author
import com.maxrt.data.Reflection

class AuthorDao extends DaoImpl[Author](Reflection.findAnnotationOrDie[Author, Table].getName(), () => new Author)
