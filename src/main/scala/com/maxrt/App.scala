package com.maxrt

import com.maxrt.db.dao.*

object App {
  def main(args : Array[String]): Unit = {
    println((new AlbumDao).getAll())
    println((new AuthorDao).getAll())
    println((new GenreDao).getAll())
    println((new MusicalLabelDao).getAll())
    println((new SavedSongDao).getAll())
    println((new SongDao).getAll())
    println((new UserDao).getAll())
  }
}
