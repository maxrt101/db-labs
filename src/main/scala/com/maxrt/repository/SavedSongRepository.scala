package com.maxrt.repository

import com.maxrt.model.SavedSong
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait SavedSongRepository extends JpaRepository[SavedSong, Int]
