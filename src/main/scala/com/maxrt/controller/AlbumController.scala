package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.AlbumService
import com.maxrt.dto.AlbumDto
import com.maxrt.model.Album

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/album"))
class AlbumController extends Controller[Album, AlbumDto] {
  @Autowired
  val albumService: AlbumService = null

  @GetMapping(path = Array("/{id}"))
  def getAlbum(@PathVariable(name = "id") id: Int): ResponseEntity[AlbumDto] = albumService.get(id) match {
    case Some(value) => new ResponseEntity(new AlbumDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllAlbums(): ResponseEntity[java.util.List[AlbumDto]] =
    new ResponseEntity(albumService.getAll().map(new AlbumDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createAlbum(@RequestBody album: Album): ResponseEntity[AlbumDto] =
    new ResponseEntity(new AlbumDto(albumService.create(album)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateAlbum(@PathVariable("id") id: Int, @RequestBody album: Album): ResponseEntity[AlbumDto] = albumService.get(id) match {
    case Some(value) =>
      album.id = id
      new ResponseEntity(new AlbumDto(albumService.create(album)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteAlbum(@PathVariable("id") id: Int): ResponseEntity[Album] = {
    albumService.delete(id)
    ResponseEntity.noContent().build()
  }
}
