package com.maxrt.db.model

import com.maxrt.db.{Table, Model, PrimaryKey}

@Table("album")
@PrimaryKey("id")
class Album(var id: Int = 0, var name: String = "", var author_id: Int = 0, var label_id: Int = 0) extends Model {
  override def toString(): String = s"Album($id, $name, $author_id, $label_id)"

  def getField(name: String): Any = name match {
    case "id"        => id
    case "name"      => this.name
    case "author_id" => author_id
    case "label_id"  => label_id
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"        => id = value.asInstanceOf[Int]
    case "name"      => this.name = value.asInstanceOf[String]
    case "author_id" => author_id = value.asInstanceOf[Int]
    case "label_id"  => label_id = value.asInstanceOf[Int]
  }
}
