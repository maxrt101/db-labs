package com.maxrt.db.model

import com.maxrt.db.{Model, PrimaryKey}
import javax.persistence._
import scala.annotation.meta.field

@Entity
@Table(name = "saved_song", schema = "itunes")
@PrimaryKey("id")
class SavedSong extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  var uid: Int = 0
  var sid: Int = 0

  def getField(name: String): Any = name match {
    case "id"  => id
    case "uid" => uid
    case "sid" => sid
  }

  def setField(name: String, value: AnyRef): Unit = name match {
    case "id"  => id  = value.asInstanceOf[Int]
    case "uid" => uid = value.asInstanceOf[Int]
    case "sid" => sid = value.asInstanceOf[Int]
  }

  override def toString(): String = s"SavedSong($id, $uid, $sid)"
}
