package com.maxrt

import com.maxrt.db.{ConnectionInfo, Table}
import com.maxrt.db.dao.*
import com.maxrt.db.model.*
import com.maxrt.console.cmd.impl.*
import com.maxrt.console.{Console, Printer}
import com.maxrt.console.cmd.{Command, CommandProcessor}
import com.maxrt.db.Table.Helper

object App {
  def main(args: Array[String]): Unit = {
    Console.clear()

    implicit val connInfo = ConnectionInfo()

    Table.heplers.addAll(List(
      ("album", Helper(new AlbumDao, new Printer[Album])),
      ("author", Helper(new AuthorDao, new Printer[Author])),
      ("genre", Helper(new GenreDao, new Printer[Genre])),
      ("musical_label", Helper(new GenreDao, new Printer[MusicalLabel])),
      ("saved_song", Helper(new SavedSongDao, new Printer[SavedSong])),
      ("song", Helper(new SongDao, new Printer[Song])),
      ("user", Helper(new UserDao, new Printer[User]))
    ))

    val cli = new CommandProcessor(List[Command](
      new ExitCommand,
      new HelpCommand,
      new ListCommand,
      new GetCommand,
      new UpdateCommand,
      new NewCommand,
      new DeleteCommand
    ))

    cli.run()
  }
}
