package com.maxrt.service

import com.maxrt.service.impl.ServiceImpl
import com.maxrt.model.MusicalLabel
import com.maxrt.repository.MusicalLabelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class MusicalLabelService extends ServiceImpl[MusicalLabel] {
  @Autowired
  override val repository: MusicalLabelRepository = null
}
