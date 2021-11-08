package com.maxrt.db.model

import com.maxrt.db.{Model, PrimaryKey}
import javax.persistence._
import scala.annotation.meta.field

@Entity
@Table(name = "user", schema = "itunes")
@PrimaryKey("uid")
class User extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var uid: Int = 0
  var username: String = ""
  var email: String = ""
  var password: String = ""

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

  override def toString(): String = s"User($uid, $username, $email, $password)"
}
