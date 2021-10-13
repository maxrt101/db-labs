package com.maxrt.db

trait Dao[T] {
  type IdType = Int

  def get(id: IdType): Option[T]
  def getAll(): List[T]
  def save(value: T): Unit
  def update(value: T): Unit
  def delete(value: T): Unit
}