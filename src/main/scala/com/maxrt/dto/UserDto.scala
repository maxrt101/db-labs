package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.User

class UserDto(user: User) extends Dto {
  def getUid = user.uid
  def getUsername = user.username
  def getEmail = user.email
  def getPassword = user.password
}
