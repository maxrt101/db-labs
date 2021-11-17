package com.maxrt.repository

import com.maxrt.model.User
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
trait UserRepository extends JpaRepository[User, Int]
