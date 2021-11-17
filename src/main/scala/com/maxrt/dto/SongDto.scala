package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.Song

class SongDto(song: Song) extends Dto {
  def getId = song.id
  def getName = song.name
  def getGenreId = song.genreId
  def getAlbumId = song.albumId
  def getPrice = song.price
  def getDownloads = song.downloads
}
