package com.rockthejvm

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42 // immutable

  // Int, Boolean, Char, Double, Float, String (types)
  val aBoolean = false

  // String and string ops
  val aString = "Blah blah"
  val aComposedString = "Blah" + "Blah"

  val aInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // similar to ternary operations in JS
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  // code block
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // final expression is the returned value of the entire code block
    aLocalValue + 45
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    x + " " + y
  }

  // recursive functions
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // the Unit type = no meaningful value === 'void' in other languages
  // type of SIDE EFFECTS (nothing to do with computing meaningful statements)
  println("blah") // returns unit

  def myUnitReturningFn(): Unit = {
    println("test")
  }

  // only real value of unit is ()
  val theUnit = ()

}
