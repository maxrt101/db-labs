package com.maxrt.console

import scala.reflect.ClassTag

import com.maxrt.db.Model
import com.maxrt.data.Reflection

class Printer[T <: Model](implicit ct: ClassTag[T]) {
  type ModelType = T

  private def printBorder(lengths: List[Int]): Unit = {
    lengths.foreach(l => {
      System.out.print("+")
      System.out.print(List.fill(l+2)('-').mkString)
    })
    println("+")
  }

  private def printField[T](value: T, length: Int): Unit = {
    System.out.print(value)
    System.out.print(List.fill(length-value.toString.length)(' ').mkString)
    System.out.print(" | ")
  }

  private def printLine[T](fields: List[T], lengths: List[Int], printer: (T) => String): Unit = {
    System.out.print("| ")
    for (i <- 0 until fields.length) {
      printField(printer(fields(i)), lengths(i))
    }
    println()
  }

  def print(value: T): Unit = {
    val fields = Reflection.getFields[T]
    val lengths = new Array[Int](fields.length)
    for (i <- 0  until fields.length) {
      val columnLength = value.getField(fields(i).getName).toString.length
      lengths.update(i, columnLength.max(fields(i).getName.length))
    }

    printBorder(lengths.toList)
    printLine(fields.toList, lengths.toList, f => f.getName)
    printBorder(lengths.toList)
    printLine(fields.toList, lengths.toList, f => value.getField(f.getName()).toString)
    printBorder(lengths.toList)
  }

  def printAll(values: List[T]): Unit = {
    val fields = Reflection.getFields[T]
    val lengths = new Array[Int](fields.length)
    for (i <- 0  until fields.length) {
      val columns = values.map(v => v.getField(fields(i).getName()))
      lengths.update(i, columns.map(_.toString.length).max.max(fields(i).getName.length))
    }

    printBorder(lengths.toList)
    printLine(fields.toList, lengths.toList, f => f.getName)
    printBorder(lengths.toList)
    values.foreach(v => printLine(fields.toList, lengths.toList, f => v.getField(f.getName()).toString))
    printBorder(lengths.toList)
  }
}
