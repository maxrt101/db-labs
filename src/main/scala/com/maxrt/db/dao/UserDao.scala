package com.maxrt.db.dao

import com.maxrt.db.Table
import com.maxrt.db.impl.DaoImpl
import com.maxrt.db.model.User
import com.maxrt.data.Reflection

class UserDao extends DaoImpl[User](Reflection.findAnnotationOrDie[User, Table].getName(), () => new User)
