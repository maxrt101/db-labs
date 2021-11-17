package com.maxrt.repository

import com.maxrt.model.MusicalLabel
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait MusicalLabelRepository extends JpaRepository[MusicalLabel, Int]
