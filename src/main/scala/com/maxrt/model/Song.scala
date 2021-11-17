package com.maxrt.model

import com.maxrt.db.{Model, PrimaryKey}
import javax.persistence._
import scala.annotation.meta.field

@Entity
@Table(name = "song", schema = "itunes")
@PrimaryKey("id")
class Song extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  var name: String = ""
  var price: Int = 0
  var downloads: Int = 0

  @Column(name = "genre_id")
  var genreId: Int = 0

  @Column(name = "album_id")
  var albumId: Int = 0

  def setId(newId: Int) = id = newId
  def setName(newName: String) = name = newName
  def setGenreId(newGenreId: Int) = genreId = newGenreId
  def setAlbumId(newAlbumId: Int) = albumId = newAlbumId
  def setPrice(newPrice: Int) = price = newPrice
  def setDownloads(newDownloads: Int) = downloads = newDownloads

  override def toString(): String = s"Song($id, $name, $genreId, $albumId, $price, $downloads)"
}
