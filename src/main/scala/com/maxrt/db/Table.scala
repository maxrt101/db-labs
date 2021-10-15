package com.maxrt.db

import scala.collection.mutable.HashMap

import com.maxrt.console.Printer

/**
 * Indicates a table name, annotates a Model
 * @param tableName - Name of the table, that the Model is stored in
 */
class Table(tableName: String) extends scala.annotation.StaticAnnotation {
  def getName() = tableName
}

object Table {
  val tables = List[String]("album", "author", "genre", "musical_label", "saved_song", "song", "user")
  val heplers = HashMap[String, (Dao[_], Printer[_])]()
}
