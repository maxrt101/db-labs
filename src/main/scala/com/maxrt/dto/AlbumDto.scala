package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.Album

class AlbumDto(album: Album) extends Dto {
  def getId = album.id
  def getName = album.name
  def getAuthorId = album.authorId
  def getLabelId = album.labelId
}
