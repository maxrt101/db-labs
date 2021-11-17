package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.Album
import com.maxrt.repository.AlbumRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class AlbumService extends ServiceImpl[Album] {
  @Autowired
  override val repository: AlbumRepository = null
}
