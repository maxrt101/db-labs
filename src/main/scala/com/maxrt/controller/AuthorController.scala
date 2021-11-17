package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.AuthorService
import com.maxrt.dto.AuthorDto
import com.maxrt.model.Author

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/author"))
class AuthorController extends Controller[Author, AuthorDto] {
  @Autowired
  val authorService: AuthorService = null

  @GetMapping(path = Array("/{id}"))
  def getAuthor(@PathVariable(name = "id") id: Int): ResponseEntity[AuthorDto] = authorService.get(id) match {
    case Some(value) => new ResponseEntity(new AuthorDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllAuthors(): ResponseEntity[java.util.List[AuthorDto]] =
    new ResponseEntity(authorService.getAll().map(new AuthorDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createAuthor(@RequestBody author: Author): ResponseEntity[AuthorDto] =
    new ResponseEntity(new AuthorDto(authorService.create(author)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateAuthor(@PathVariable("id") id: Int, @RequestBody author: Author): ResponseEntity[AuthorDto] = authorService.get(id) match {
    case Some(value) =>
      author.id = id
      new ResponseEntity(new AuthorDto(authorService.create(author)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteAuthor(@PathVariable("id") id: Int): ResponseEntity[Author] = {
    authorService.delete(id)
    ResponseEntity.noContent().build()
  }
}
