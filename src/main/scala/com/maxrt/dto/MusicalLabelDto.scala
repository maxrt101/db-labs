package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.MusicalLabel

class MusicalLabelDto(musicalLabel: MusicalLabel) extends Dto {
  def getId = musicalLabel.id
  def getName = musicalLabel.name
}
