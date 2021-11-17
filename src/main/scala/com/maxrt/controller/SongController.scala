package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.SongService
import com.maxrt.dto.SongDto
import com.maxrt.model.Song

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/song"))
class SongController extends Controller[Song, SongDto] {
  @Autowired
  val songService: SongService = null

  @GetMapping(path = Array("/{id}"))
  def getSong(@PathVariable(name = "id") id: Int): ResponseEntity[SongDto] = songService.get(id) match {
    case Some(value) => new ResponseEntity(new SongDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllSongs(): ResponseEntity[java.util.List[SongDto]] =
    new ResponseEntity(songService.getAll().map(new SongDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createSong(@RequestBody song: Song): ResponseEntity[SongDto] =
    new ResponseEntity(new SongDto(songService.create(song)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateSong(@PathVariable("id") id: Int, @RequestBody song: Song): ResponseEntity[SongDto] = songService.get(id) match {
    case Some(value) =>
      song.id = id
      new ResponseEntity(new SongDto(songService.create(song)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteSong(@PathVariable("id") id: Int): ResponseEntity[Song] = {
    songService.delete(id)
    ResponseEntity.noContent().build()
  }
}
