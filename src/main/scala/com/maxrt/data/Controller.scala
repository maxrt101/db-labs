package com.maxrt.data

import com.maxrt.db.{Dao, Model}
import com.maxrt.console.Printer

import scala.collection.mutable.HashMap

trait Controller[T <: Model] {
  type IdType = Int

  def get(id: IdType): Unit

  def getAll(): Unit

  def update(id: IdType): Unit

  def delete(id: IdType): Unit

  def create(): Unit

}

object Controller {
  val controllers = HashMap[String, Controller[_]]()
}
