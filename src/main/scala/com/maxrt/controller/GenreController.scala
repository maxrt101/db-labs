package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.GenreService
import com.maxrt.dto.GenreDto
import com.maxrt.model.Genre

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/genre"))
class GenreController extends Controller[Genre, GenreDto] {
  @Autowired
  val genreService: GenreService = null

  @GetMapping(path = Array("/{id}"))
  def getGenre(@PathVariable(name = "id") id: Int): ResponseEntity[GenreDto] = genreService.get(id) match {
    case Some(value) => new ResponseEntity(new GenreDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllGenres(): ResponseEntity[java.util.List[GenreDto]] =
    new ResponseEntity(genreService.getAll().map(new GenreDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createGenre(@RequestBody genre: Genre): ResponseEntity[GenreDto] =
    new ResponseEntity(new GenreDto(genreService.create(genre)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateGenre(@PathVariable("id") id: Int, @RequestBody genre: Genre): ResponseEntity[GenreDto] = genreService.get(id) match {
    case Some(value) =>
      genre.id = id
      new ResponseEntity(new GenreDto(genreService.create(genre)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteGenre(@PathVariable("id") id: Int): ResponseEntity[Genre] = {
    genreService.delete(id)
    ResponseEntity.noContent().build()
  }
}
