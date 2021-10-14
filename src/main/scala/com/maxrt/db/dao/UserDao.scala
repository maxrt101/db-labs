package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.User
import com.maxrt.data.Reflection

class UserDao extends DaoImpl[User](
  Reflection.findAnnotationOrDie[User, Table].getName(),
  Reflection.findAnnotationOrDie[User, PrimaryKey].getPrimaryKeyName(),
  () => new User)
