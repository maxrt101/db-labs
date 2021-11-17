package com.maxrt.repository

import com.maxrt.model.Album
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait AlbumRepository extends JpaRepository[Album, Int]
