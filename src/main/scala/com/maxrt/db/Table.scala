package com.maxrt.db

/**
 * Indicates a table name, annotates a Model
 * @param tableName - Name of the table, that the Model is stored in
 */
class Table(tableName: String) extends scala.annotation.StaticAnnotation {
  def getName() = tableName
}
