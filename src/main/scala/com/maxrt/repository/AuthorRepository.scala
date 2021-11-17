package com.maxrt.repository

import com.maxrt.model.Author
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait AuthorRepository extends JpaRepository[Author, Int]
