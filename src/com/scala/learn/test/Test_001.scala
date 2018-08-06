package com.scala.learn.test

/**
  * Created by 宋先森 on 2018/8/4.
  */
/**
  * 在path、package下；文件可以包含多个object/class，但是包下的class/object不能重名，这也符合Java全限命名的唯一性
  * 但是；class和object之间可以重名-->伴生对象、伴生类
  * 在scala中
  * object：静态类（单例对象）
  * 主方法；只能作用在object中
  * class；就是类型，被new出来得到对象
  * 参数列表中的参数就是类的成员变量,且是private,默认是val/var..这个是特殊场景.方法/函数,参数只能是默认的val
  * var/val修饰的变量  var 可变   val 不可变
  * class中可以重写构造，但要调用默认构造，为了给默认构造中的成员变量赋值
  * 对于的参数需要我们在class文件的单独去做变量赋值
  *   多余的参数需要我们在class中手工定义成员变量进行手工赋值:::var类型的,可变
  */
object Test_001 {
  def main(args: Array[String]): Unit = {
    println("hello world")
  }
}

object test_002 {


  println("test_002")
  var clazz = new test_002()
  clazz.i = 4
  println(clazz.i)

  //to和until 的用法（不带步长，带步长区别）Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(1 to 10)
  //带步长   Range(1, 3, 5, 7, 9)
  println(1 to (10,2))
  //Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(1 until 10)
  //Range(1, 3, 5, 7, 9)
  println(1 until (10,2))


  def main(args: Array[String]): Unit = {
    println("test_002_main")
  }
}

class test_002 {
  var i = 3
  println("伴生对象")
}

class class_001 {
  var i = 1
}



















