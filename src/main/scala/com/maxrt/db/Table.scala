package com.maxrt.db

/**
 * Indicates a table name, annotates a Model
 */
class Table(tableName: String) extends scala.annotation.StaticAnnotation {
  def getName() = tableName
}
