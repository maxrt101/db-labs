package com.maxrt.db.model

import com.maxrt.db.{Table, Model, PrimaryKey}

@Table("genre")
@PrimaryKey("id")
class Genre(var id: Int = 0, var name: String = "") extends Model {
  override def toString(): String = s"Genre($id, $name)"

  def getField(name: String): Any = name match {
    case "id"   => id
    case "name" => this.name
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"   => id = value.asInstanceOf[Int]
    case "name" => this.name = value.asInstanceOf[String]
  }
}
