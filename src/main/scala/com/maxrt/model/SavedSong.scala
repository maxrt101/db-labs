package com.maxrt.model

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

  @Column(name = "uid")
  var uid: Int = 0

  @Column(name = "sid")
  var sid: Int = 0

  def setId(newId: Int) = id = newId
  def setUid(newUid: Int) = uid = newUid
  def setSid(newSid: Int) = sid = newSid

  override def toString(): String = s"SavedSong($id, $uid, $sid)"
}
