package com.maxrt.db

abstract class Model {
  def getField(name: String): Any
  def setField(name: String, value: AnyRef): Unit
}
