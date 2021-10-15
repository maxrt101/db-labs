package com.maxrt.db.impl

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.*
import scala.collection.mutable.ArrayBuffer

import java.sql.ResultSet
import java.sql.SQLException

import com.maxrt.db.{Connection, ConnectionInfo, Model, Table, Dao}
import com.maxrt.data.Reflection

/**
 * Data Access Object Implementation
 * TODO make `tableName`, `primaryKeyName` & `creator` implicit (using inline macros or smth)
 * @tparam T - Descendant of Model, represents a DB model
 * @param tableName - Table name for Model
 * @param creator - Function for object T creation (needed because of type erasure & inability to invoke constructor from Class<T>.newInstance)
 * @param ct - Implicit ClassTag[T] to capture type information about T
 */
class DaoImpl[T <: Model](tableName: String, primaryKeyName: String, creator: () => T)(implicit ct: ClassTag[T]) extends Dao[T] {

  def get(id: IdType): Option[T] = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return Option.empty[T]
    }
    try {
      val stmt = connection.createStatement()
      val rs = stmt.executeQuery(s"SELECT * FROM $tableName WHERE $primaryKeyName=$id")
      if (rs.next) {
        val value = creator()
        val fields = Reflection.getFields[T]
        fields.foreach((f) => value.setField(f.getName(), rs.getObject(f.getName())))
        return Option(value)
      }
    } catch {
      case ex: SQLException => ex.printStackTrace() // TODO rethrow
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
      val rs = stmt.executeQuery(s"SELECT * FROM $tableName")
      val fields = Reflection.getFields[T]
      while (rs.next) {
        val value = creator()
        fields.foreach(f => value.setField(f.getName(), rs.getObject(f.getName())))
        rows.append(value)
      }
    } catch {
      case ex: SQLException => ex.printStackTrace() // TODO rethrow
    }

    return rows.toList
  }

  def save(value: T): Unit = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return
    }
    try {
      val stmt = connection.createStatement()
      val fields = Reflection.getFields[T]
      var query = s"INSERT INTO $tableName VALUES ("
      fields.foreach(f => {
        query = query + (if fields.head != f  then ", '" else "'") + value.getField(f.getName()) + "'"
      })
      query = query + ")"
      stmt.executeUpdate(query)
    } catch {
      case ex: SQLException => ex.printStackTrace() // TODO rethrow
    }
  }

  def update(value: T, fieldName: String = ""): Unit = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return
    }
    try {
      val stmt = connection.createStatement()
      val fields = Reflection.getFields[T]
      if (fieldName.isEmpty()) {
        fields.foreach(f => {
          val query = s"UPDATE $tableName SET ${f.getName()} = '${value.getField(f.getName())}' WHERE $primaryKeyName = ${value.getField(primaryKeyName)}"
          stmt.executeUpdate(query)
        })
      } else {
        val query = s"UPDATE $tableName SET ${fieldName} = '${value.getField(fieldName)}' WHERE $primaryKeyName = ${value.getField(primaryKeyName)}"
        stmt.executeUpdate(query)
      }
    } catch {
      case ex: SQLException => ex.printStackTrace() // TODO rethrow
    }
  }

  def delete(value: T): Unit = {
    val connection = Connection.getConnection(ConnectionInfo()) match {
      case Some(conn) => conn
      case None => return
    }
    try {
      val stmt = connection.createStatement()
      val query = s"DELETE FROM $tableName WHERE $primaryKeyName = ${value.getField(primaryKeyName)}"
      stmt.executeUpdate(query)
    } catch {
      case ex: SQLException => ex.printStackTrace() // TODO rethrow
    }
  }

  def getModelClassTag(): ClassTag[T] = ct

  def newModelInstance(): T = creator()
}

