package com.maxrt.db

case class ConnectionInfo(var driver: String = "com.mysql.cj.jdbc.Driver",
                          val url: String = "jdbc:mysql://localhost/itunes",
                          val username: String = "root",
                          val password: String = "")
