package com.maxrt.db.model

import com.maxrt.db.{Model, Table, PrimaryKey}

@Table("author")
@PrimaryKey("id")
class Author(var id: Int = 0, var name: String = "") extends Model {
  override def toString(): String = s"Author($id, $name)"

  def getField(name: String): Any = name match {
    case "id"   => id
    case "name" => this.name
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"   => id = value.asInstanceOf[Int]
    case "name" => this.name = value.asInstanceOf[String]
  }
}
