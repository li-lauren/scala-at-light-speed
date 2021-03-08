package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance
  class Animal {
    // define field
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition
  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields: need to put a val before the constructor
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class (not all fields/methods need to necessarily have implementation)
  abstract class WalkingAnimal {
    protected val hasLegs = true // by default public, can restrict by protected / private
    def walk(): Unit
  }

  // "interface" = ultimate abstract type (everything can be left unimplemented)
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // Scala is very permissive with method names
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher{
    override def eat(animal: Animal): Unit = println("I am eating you, animal")
    override def ?!(thought: String): Unit = println(s"I am thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation => object method argument (only works when there is a single arg)
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2 // addition is a method belong to int type
  val anotherBasicMath = 1.+(2) // equivalent




}
