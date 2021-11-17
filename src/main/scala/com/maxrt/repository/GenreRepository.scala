package com.maxrt.repository

import com.maxrt.model.Genre
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait GenreRepository extends JpaRepository[Genre, Int]
