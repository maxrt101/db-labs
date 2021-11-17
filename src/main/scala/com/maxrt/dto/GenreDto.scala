package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.Genre

class GenreDto(genre: Genre) extends Dto {
  def getId = genre.id
  def getName = genre.name
}
