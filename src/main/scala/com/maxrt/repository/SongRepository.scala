package com.maxrt.repository

import com.maxrt.model.Song
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait SongRepository extends JpaRepository[Song, Int]
