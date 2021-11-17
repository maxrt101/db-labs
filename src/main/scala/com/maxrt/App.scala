package com.maxrt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(Array("com.maxrt.controller", "com.maxrt.service", "com.maxrt.repository", "com.maxrt.data"))
@SpringBootApplication
class BootApplication

object App {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[BootApplication])
}
