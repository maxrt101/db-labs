package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.Song
import com.maxrt.repository.SongRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class SongService extends ServiceImpl[Song] {
  @Autowired
  override val repository: SongRepository = null
}
