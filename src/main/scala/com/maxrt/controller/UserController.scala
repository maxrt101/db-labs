package com.maxrt.controller

import com.maxrt.data.Controller
import com.maxrt.service.UserService
import com.maxrt.dto.UserDto
import com.maxrt.model.User

import scala.jdk.CollectionConverters._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{ResponseEntity, HttpStatus, MediaType}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/user"))
class UserController extends Controller[User, UserDto] {
  @Autowired
  val userService: UserService = null

  @GetMapping(path = Array("/{id}"))
  def getUser(@PathVariable(name = "id") id: Int): ResponseEntity[UserDto] = userService.get(id) match {
    case Some(value) => new ResponseEntity(new UserDto(value), HttpStatus.OK)
    case None        => new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @GetMapping
  def getAllUsers(): ResponseEntity[java.util.List[UserDto]] =
    new ResponseEntity(userService.getAll().map(new UserDto(_)).asJava, HttpStatus.OK)

  @PostMapping
  def createUser(@RequestBody user: User): ResponseEntity[UserDto] =
    new ResponseEntity(new UserDto(userService.create(user)), HttpStatus.OK)

  @PutMapping(path = Array("/{id}"))
  def updateUser(@PathVariable("id") id: Int, @RequestBody user: User): ResponseEntity[UserDto] = userService.get(id) match {
    case Some(value) =>
      user.uid = id
      new ResponseEntity(new UserDto(userService.create(user)), HttpStatus.OK)
    case None =>
      new ResponseEntity(HttpStatus.NOT_FOUND)
  }

  @DeleteMapping(path = Array("/{id}"))
  def deleteUser(@PathVariable("id") id: Int): ResponseEntity[User] = {
    userService.delete(id)
    ResponseEntity.noContent().build()
  }
}
