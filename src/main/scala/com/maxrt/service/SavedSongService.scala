package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.SavedSong
import com.maxrt.repository.SavedSongRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class SavedSongService extends ServiceImpl[SavedSong] {
  @Autowired
  override val repository: SavedSongRepository = null
}
