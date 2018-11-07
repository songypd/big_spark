package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/11/7.
  */

//class rabbit(n: String) {
//  val name = n
//}
//
//class animal(name: String) {
//  def canfly() {
//    println(s"$name can fly...")
//  }
//}

//

object implicitDemo {
  //  函数的隐式转换
  //  implicit def rabbit2animal(r: rabbit):animal= {
  //    new animal(r.name)
  //  }
  //
  //  def main(args: Array[String]): Unit = {
  //    val rab = new rabbit("xiaobai")
  //    rab.canfly()
  //
  //  }

  /**
    * 隐式值与隐式参数
    * 隐式转换作用就是：当调用方法时，不必手动传入方法中的隐式参数，Scala会自动在作用域范围内寻找隐式值自动传入
    */
  //  def Student(age:Int)(implicit name:String,i:Int)= {
  //    println( s"student :$name ,age = $age ,score = $i")
  //  }
  //  def Teacher(implicit name:String) ={
  //    println(s"teacher name is = $name")
  //  }
  //
  //  def main(args: Array[String]): Unit = {
  //    implicit val zs = "zhangsan"
  //    implicit val sr = 100
  //
  //    Student(18)
  //    Teacher
  //  }
}
