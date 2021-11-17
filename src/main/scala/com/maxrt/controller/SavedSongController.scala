package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.SavedSongService
import com.maxrt.dto.SavedSongDto
import com.maxrt.model.SavedSong

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/savedSong"))
class SavedSongController extends Controller[SavedSong, SavedSongDto] {
  @Autowired
  val savedSongService: SavedSongService = null

  @GetMapping(path = Array("/{id}"))
  def getSavedSong(@PathVariable(name = "id") id: Int): ResponseEntity[SavedSongDto] = savedSongService.get(id) match {
    case Some(value) => new ResponseEntity(new SavedSongDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllSavedSongs(): ResponseEntity[java.util.List[SavedSongDto]] =
    new ResponseEntity(savedSongService.getAll().map(new SavedSongDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createSavedSong(@RequestBody savedSong: SavedSong): ResponseEntity[SavedSongDto] =
    new ResponseEntity(new SavedSongDto(savedSongService.create(savedSong)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateSavedSong(@PathVariable("id") id: Int, @RequestBody savedSong: SavedSong): ResponseEntity[SavedSongDto] = savedSongService.get(id) match {
    case Some(value) =>
      savedSong.id = id
      new ResponseEntity(new SavedSongDto(savedSongService.create(savedSong)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteSavedSong(@PathVariable("id") id: Int): ResponseEntity[SavedSong] = {
    savedSongService.delete(id)
    ResponseEntity.noContent().build()
  }
}
