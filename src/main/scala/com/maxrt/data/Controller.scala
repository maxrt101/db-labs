package com.maxrt.data

import com.maxrt.db.Model
import com.maxrt.data.Dto

import scala.collection.mutable.HashMap

trait Controller[T <: Model, D <: Dto]
