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

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dino eating")
  }

  /*
    What you tell the compiler:

    class Carnivore_Anonymous_3743 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I am a dino eating")
    }
   */

  // singleton object (particular to Scala)
  object MySingleton {
    val mySpecialValue = 53785
    def mySpecialMethod(): Int = 4345
    def apply(x: Int): Int = x + 1 // allow instances of the class to invoke these functions
  } // the only instance of the MySingleton type

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton apply method

  // companions - companion object
  object Animal {
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
    case classes = lightweight data structures w/ some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
   */

  case class Person(name: String, age: Int)
  // may be constructed without "new"
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concerte type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("Reasoning about")
   */

  val reversedList = aList.reverse // returns a NEW list

  // Point #2 Scala is closest to the OO Ideal
  // all code is inside some instance of a type (inside some class or object)

}
