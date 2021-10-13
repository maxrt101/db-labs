package com.maxrt.db

import java.sql.DriverManager
import java.sql.Connection

import com.maxrt.db.ConnectionInfo

/**
 * Wrapper for a java.sql.Connection
 * TODO think about rewiriting this using connection loop
 */
object Connection {
  def getConnection(connInfo: ConnectionInfo): Option[java.sql.Connection] = {
    var connection: java.sql.Connection = null
    Class.forName(connInfo.driver)
    connection = DriverManager.getConnection(connInfo.url, connInfo.username, connInfo.password)
    if connection != null then Option(connection) else Option.empty[Connection]
  }
}
