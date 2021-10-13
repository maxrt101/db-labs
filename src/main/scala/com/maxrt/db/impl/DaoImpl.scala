package com.maxrt.db.impl

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.*
import scala.collection.mutable.ArrayBuffer

import java.sql.ResultSet
import java.sql.SQLException

import com.maxrt.db.{Connection, ConnectionInfo, Model, Table, Dao}
import com.maxrt.data.Reflection

/**
 * Data Access Object
 */
class DaoImpl[T <: Model](tableName: String, creator: () => T)(implicit ct: ClassTag[T]) extends Dao[T] {

  def get(id: IdType): Option[T] = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return Option.empty[T]
    }
    try {
      val stmt = connection.createStatement()
      val rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id=" + id)
      if (rs.next) {
        val value = creator()
        val fields = Reflection.getFields[T]
        fields.foreach((f) => value.setField(f.getName(), rs.getObject(f.getName())))
        return Option(value)
      }
    } catch {
      case ex: SQLException => ex.printStackTrace()
    }

    Option.empty[T]
  }

  def getAll(): List[T] = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return List.empty[T]
    }
    val rows = new ArrayBuffer[T]
    try {
      val stmt = connection.createStatement()
      val rs = stmt.executeQuery("SELECT * FROM " + tableName)
      val fields = Reflection.getFields[T]
      while (rs.next) {
        val value = creator()
        fields.foreach(f => value.setField(f.getName(), rs.getObject(f.getName())))
        rows.append(value)
      }
    } catch {
      case ex: SQLException => ex.printStackTrace()
    }

    return rows.toList
  }

  def save(value: T): Unit = null

  def update(value: T): Unit = null

  def delete(value: T): Unit = null
}

