package com.maxrt.model

import com.maxrt.db.{Model, PrimaryKey}
import javax.persistence._
import scala.annotation.meta.field

@Entity
@Table(name = "album", schema = "itunes")
@PrimaryKey("id")
class Album extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  var name: String = ""

  @Column(name = "author_id")
  var authorId: Int = 0

  @Column(name = "label_id")
  var labelId: Int = 0

  def setId(newId: Int) = id = newId
  def setName(newName: String) = name = newName
  def setAuthorId(newAuthorId: Int) = authorId = newAuthorId
  def setLabelId(newLabelId: Int) = labelId = newLabelId

  override def toString(): String = s"Album($id, $name, ${authorId}, ${labelId})"
}
