package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/7.
  */

;

/*
trait	特性
1.概念理解
  Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。
  与接口不同的是，它还可以定义属性和方法的实现。
  一般情况下Scala的类可以继承多个Trait，从结果来看就是实现了多重继承。Trait(特征) 定义的方式与类类似，但它使用的关键字是 trait。

2.举例：trait中带属性带方法实现
  注意：
    继承的多个trait中如果有同名的方法和属性，必须要在类中使用“override”重新定义。
    trait中不可以传参数
*/


trait clazz_001{
  val read = "read"
  val name = "tom"
  def fun_read(action:String): Unit ={
    println(action)
  }
}

trait clazz_002{
  val write = "write"
  val name="tom"
  def fun_write(action:String): Unit ={
    println(action)
  }
}

class person() extends clazz_001 with clazz_002{
  override val name = "jack"
}


object scala_trait_001 {

  def main(args: Array[String]): Unit = {
    val person = new person

    println(person.read)
    person.fun_read("rea")
    println(person.write)
    person.fun_write("writ")
    println(person.name)


  }
}

/**
  * trait带方法不实现
  */

object Lesson_Trait2 {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(1,2)
    val p2 = new Point(1,3)
    println(p1.isEqule(p2))
    println(p1.isNotEqule(p2))
  }
}

trait Equle{
  def isEqule(x:Any) :Boolean
  def isNotEqule(x : Any)  = {
    !isEqule(x)
  }
}

class Point(x:Int, y:Int) extends Equle {
  val xx = x
  val yy = y

  def isEqule(p:Any) = {
    p.isInstanceOf[Point] && p.asInstanceOf[Point].xx==xx
  }

}