package com.maxrt.data

import scala.reflect.ClassTag
import scala.quoted.*
import scala.sys.error

object Reflection {
  def getFields[T: ClassTag] = implicitly[ClassTag[T]].runtimeClass.getDeclaredFields()
  
  inline def findAnnotation[T, A] = ${findAnnotationImpl[T, A]}

  def findAnnotationImpl[T: Type, A: Type](using Quotes): Expr[Option[A]] = {
    import quotes.reflect.*
    TypeRepr.of[T].typeSymbol.annotations.find(_.tpe <:< TypeRepr.of[A]) match {
      case Some(tree) => '{ Some(${tree.asExprOf[A]}) }
      case None       => '{ None }
    }
  }

  inline def findAnnotationOrDie[T, A] = ${findAnnotationOrDieImpl[T, A]}

  def findAnnotationOrDieImpl[T: Type, A: Type](using Quotes): Expr[A] = {
    import quotes.reflect.*
    TypeRepr.of[T].typeSymbol.annotations.find(_.tpe <:< TypeRepr.of[A]) match {
      case Some(tree) => tree.asExprOf[A]
      case None       => error("No Annotation " + TypeRepr.of[A].toString + " found")
    }
  }

  inline def getAnnotations[T]: List[String] = ${getAnnotationsImpl[T]}

  def getAnnotationsImpl[T: Type](using Quotes): Expr[List[String]] = {
    import quotes.reflect.*
    val annotations = TypeRepr.of[T].typeSymbol.annotations.map(_.tpe.show)
    Expr.ofList(annotations.map(Expr(_)))
  }
}
