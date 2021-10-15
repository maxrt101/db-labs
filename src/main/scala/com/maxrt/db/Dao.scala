package com.maxrt.db

/**
 * Data Access Object Trait
 */
trait Dao[T <: Model] {
  type IdType = Int
  type ModelType = T

  /**
   * Gets a row from table by id
   *
   * @param id - Id
   * @return Option[T] - Empty, if no row with such id is found
   */
  def get(id: IdType): Option[T]

  /**
   * Gets all rows
   *
   * @return List[T] - A list that contains all rows from the table
   */
  def getAll(): List[T]

  /**
   * Saves new value in the table
   *
   * @param value - Value to save
   */
  def save(value: T): Unit

  /**
   * Updated a value in the table
   *
   * @param value - Value to update
   * @param fieldName - name of the field to be updated, if empty - all fields will be updated
   */
  def update(value: T, fieldName: String = ""): Unit

  /**
   * Deletes a value in the table
   *
   * @param value - Value to delete
   */
  def delete(value: T): Unit
}