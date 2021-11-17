package com.maxrt.model

import com.maxrt.db.{Model, PrimaryKey}
import javax.persistence._
import scala.annotation.meta.field

@Entity
@Table(name = "author", schema = "itunes")
@PrimaryKey("id")
class Author extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  var name: String = ""

  def setId(newId: Int) = id = newId
  def setName(newName: String) = name = newName

  override def toString(): String = s"Author($id, $name)"
}
