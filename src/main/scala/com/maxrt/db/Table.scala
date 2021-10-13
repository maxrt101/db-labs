package com.maxrt.db

class Table(tableName: String) extends scala.annotation.StaticAnnotation {
  def getName() = tableName
}
