package com.maxrt.model

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

  def setUid(newUid: Int) = uid = newUid
  def setUsername(newUsername: String) = username = newUsername
  def setEmail(newEmail: String) = email = newEmail
  def setPassword(newPassword: String) = password = newPassword

  override def toString(): String = s"User($uid, $username, $email, $password)"
}
