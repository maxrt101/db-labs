package com.maxrt.db.model

import com.maxrt.db.{Table, Model}

@Table("saved_song")
class SavedSong(var id: Int = 0, var uid: Int = 0, var sid: Int = 0) extends Model {
  override def toString(): String = s"SavedSong($id, $uid, $sid)"

  def getField(name: String): Any = name match {
    case "id"  => id
    case "uid" => uid
    case "sid" => sid
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"  => id = value.asInstanceOf[Int]
    case "uid" => uid = value.asInstanceOf[Int]
    case "sid" => sid = value.asInstanceOf[Int]
  }
}
