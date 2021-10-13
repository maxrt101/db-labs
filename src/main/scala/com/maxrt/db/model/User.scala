package com.maxrt.db.model

import com.maxrt.db.{Table, Model}

@Table("user")
class User(var uid: Int = 0,
           var username: String = "",
           var email: String = "",
           var password: String = "") extends Model {
  override def toString(): String = s"User($uid, $username, $email, $password)"

  def getField(name: String): Any = name match {
    case "uid"      => uid
    case "username" => username
    case "email"    => email
    case "password" => password
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "uid"      => uid = value.asInstanceOf[Int]
    case "username" => username = value.asInstanceOf[String]
    case "email"    => email = value.asInstanceOf[String]
    case "password" => password = value.asInstanceOf[String]
  }
}
