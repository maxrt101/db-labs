package com.maxrt

import com.maxrt.db.Table
import com.maxrt.db.dao.*
import com.maxrt.db.model.*
import com.maxrt.console.cmd.impl.*
import com.maxrt.console.{Console, Printer}
import com.maxrt.console.cmd.{CommandProcessor, Command}

object App {
  def main(args: Array[String]): Unit = {
    Console.clear()

    Table.heplers.addAll(List(
      ("album", (new AlbumDao, new Printer[Album])),
      ("author", (new AuthorDao, new Printer[Author])),
      ("genre", (new GenreDao, new Printer[Genre])),
      ("musical_label", (new GenreDao, new Printer[MusicalLabel])),
      ("saved_song", (new SavedSongDao, new Printer[SavedSong])),
      ("song", (new SongDao, new Printer[Song])),
      ("user", (new UserDao, new Printer[User]))
    ))

    val cli = new CommandProcessor(List[Command](
      new ExitCommand,
      new HelpCommand,
      new ListCommand,
      new GetCommand
    ))

    cli.run()
  }
}
