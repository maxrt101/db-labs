package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.Author
import com.maxrt.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class AuthorService extends ServiceImpl[Author] {
  @Autowired
  override val repository: AuthorRepository = null
}
