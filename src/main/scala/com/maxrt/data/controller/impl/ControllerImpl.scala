package com.maxrt.data.controller.impl

import com.maxrt.db.{ConnectionInfo, Dao, Model}
import com.maxrt.data.{Controller, Reflection}
import com.maxrt.console.Printer

import scala.io.StdIn.readLine

class ControllerImpl[T <: Model](dao: Dao[T], printer: Printer[T]) extends Controller[T] {
  type IdType = dao.IdType

  def get(id: IdType): Unit = {
    dao.get(id) match {
      case Some(value)  => printer.print(value.asInstanceOf[printer.ModelType])
      case None         => println("No such record")
    }
  }

  def getAll(): Unit = {
    val values = dao.getAll().map(_.asInstanceOf[printer.ModelType])
    printer.printAll(values)
  }

  def update(id: IdType): Unit = {
    val model = dao.get(id) match {
      case Some(value) => value
      case None => println("No such record"); return
    }

    val fields = Reflection.getFields[dao.ModelType](dao.getModelClassTag())

    for (i <- 0 until fields.length) {
      print(s"${fields(i).getName}[${model.getField(fields(i).getName)}]: ")
      val input = readLine()
      if (input.length > 0) {
        model.setField(fields(i).getName(), if fields(i).getType.toString == "int" then input.toInt.asInstanceOf[AnyRef] else input)
      }
    }

    dao.update(model)
  }

  def delete(id: IdType): Unit = {
    val model = dao.get(id) match {
      case Some(value) => value
      case None => println("No such record"); return
    }
    dao.delete(model)
  }

  def create(): Unit = {
    val value = dao.newModelInstance()

    val fields = Reflection.getFields[dao.ModelType](dao.getModelClassTag())

    for (i <- 0 until fields.length) {
      print(s"${fields(i).getName}: ")
      val input = readLine()
      if (input.length > 0) {
        value.setField(fields(i).getName(), if fields(i).getType.toString == "int" then input.toInt.asInstanceOf[AnyRef] else input)
      }
    }

    dao.save(value)
  }
}
