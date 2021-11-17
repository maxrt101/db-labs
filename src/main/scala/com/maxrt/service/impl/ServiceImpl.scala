package com.maxrt.service.impl

import com.maxrt.db.Model
import com.maxrt.data.Service
import com.maxrt.data.Reflection
import scala.jdk.OptionConverters._
import scala.jdk.CollectionConverters._
import org.springframework.data.jpa.repository.JpaRepository

abstract class ServiceImpl[T <: Model] extends Service[T] {
  def get(id: Int): Option[T] = repository.findById(id).toScala

  def getAll(): List[T] = repository.findAll().asScala.toList

  def update(value: T): T = repository.save(value)

  def create(value: T): T = repository.save(value)

  def delete(id: Int): Unit = repository.deleteById(id)
}
