package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.MusicalLabelService
import com.maxrt.dto.MusicalLabelDto
import com.maxrt.model.MusicalLabel

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/musicalLabel"))
class MusicalLabelController extends Controller[MusicalLabel, MusicalLabelDto] {
  @Autowired
  val musicalLabelService: MusicalLabelService = null

  @GetMapping(path = Array("/{id}"))
  def getMusicalLabel(@PathVariable(name = "id") id: Int): ResponseEntity[MusicalLabelDto] = musicalLabelService.get(id) match {
    case Some(value) => new ResponseEntity(new MusicalLabelDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllMusicalLabels(): ResponseEntity[java.util.List[MusicalLabelDto]] =
    new ResponseEntity(musicalLabelService.getAll().map(new MusicalLabelDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createMusicalLabel(@RequestBody musicalLabel: MusicalLabel): ResponseEntity[MusicalLabelDto] =
    new ResponseEntity(new MusicalLabelDto(musicalLabelService.create(musicalLabel)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateMusicalLabel(@PathVariable("id") id: Int, @RequestBody musicalLabel: MusicalLabel): ResponseEntity[MusicalLabelDto] = musicalLabelService.get(id) match {
    case Some(value) =>
      musicalLabel.id = id
      new ResponseEntity(new MusicalLabelDto(musicalLabelService.create(musicalLabel)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteMusicalLabel(@PathVariable("id") id: Int): ResponseEntity[MusicalLabel] = {
    musicalLabelService.delete(id)
    ResponseEntity.noContent().build()
  }
}