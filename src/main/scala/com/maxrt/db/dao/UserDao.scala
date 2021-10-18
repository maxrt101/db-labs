package com.maxrt.db.dao

import com.maxrt.db.{PrimaryKey, Table, ConnectionInfo}
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.User
import com.maxrt.data.Reflection

class UserDao(implicit connInfo: ConnectionInfo) extends DaoImpl[User](
  Reflection.findAnnotationOrDie[User, Table].getName(),
  Reflection.findAnnotationOrDie[User, PrimaryKey].getPrimaryKeyName(),
  () => new User)
