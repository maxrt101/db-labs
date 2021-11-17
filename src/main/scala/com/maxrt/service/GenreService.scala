package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.Genre
import com.maxrt.repository.GenreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class GenreService extends ServiceImpl[Genre] {
  @Autowired
  override val repository: GenreRepository = null
}
