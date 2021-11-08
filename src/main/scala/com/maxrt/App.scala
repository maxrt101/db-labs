package com.maxrt

import com.maxrt.db.SessionManager
import com.maxrt.data.Controller
import com.maxrt.data.controller.*
import com.maxrt.console.Console
import com.maxrt.console.cmd.{Command, CommandProcessor}
import com.maxrt.console.cmd.impl.*

object App {
  def main(args: Array[String]): Unit = {
    Console.clear()

    Controller.controllers.addAll(List(
      ("album", new AlbumController),
      ("author", new AuthorController),
      ("genre", new GenreController),
      ("musical_label", new MusicalLabelController),
      ("saved_song", new SavedSongController),
      ("song", new SongController),
      ("user", new UserController)
    ))

    val cli = new CommandProcessor(List[Command](
      new HelpCommand,
      new ListCommand,
      new GetCommand,
      new UpdateCommand,
      new NewCommand,
      new DeleteCommand
    ))

    SessionManager.openSession()
    cli.run()
    SessionManager.closeSession()
  }
}
