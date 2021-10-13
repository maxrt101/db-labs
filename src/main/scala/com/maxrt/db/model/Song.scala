package com.maxrt.db.model

import com.maxrt.db.{Table, Model}

@Table("song")
class Song(var id: Int = 0,
           var name: String = "",
           var genre_id: Int = 0,
           var album_id: Int = 0,
           var price: Int = 0,
           var downloads: Int = 0) extends Model {
  override def toString(): String = s"Song($id, $name, $genre_id, $album_id, $price, $downloads)"

  def getField(name: String): Any = name match {
    case "id"        => id
    case "name"      => this.name
    case "genre_id"  => genre_id
    case "album_id"  => album_id
    case "price"     => price
    case "downloads" => downloads
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"        => id = value.asInstanceOf[Int]
    case "name"      => this.name = value.asInstanceOf[String]
    case "genre_id"  => genre_id = value.asInstanceOf[Int]
    case "album_id"  => album_id = value.asInstanceOf[Int]
    case "price"     => price = value.asInstanceOf[Int]
    case "downloads" => downloads = value.asInstanceOf[Int]
  }
}
