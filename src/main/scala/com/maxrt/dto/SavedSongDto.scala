package com.maxrt.dto

import com.maxrt.data.Dto
import com.maxrt.model.SavedSong

class SavedSongDto(savedSong: SavedSong) extends Dto {
  def getId = savedSong.id
  def getUid = savedSong.uid
  def getSid = savedSong.sid
}
