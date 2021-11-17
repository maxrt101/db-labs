package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.Author

class AuthorDto(author: Author) extends Dto {
  def getId = author.id
  def getName = author.name
}
