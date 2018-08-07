package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/7.
  * 样例类(case classes)
  */

/*1.概念理解
        使用了case关键字的类定义就是样例类(case classes)，样例类是种特殊的类。实现了类构造参数的getter方法（构造参数默认被声明为val），
        当构造参数是声明为var类型的，它将帮你实现setter和getter方法。
            样例类默认帮你实现了toString,equals，copy和hashCode等方法。
            样例类可以new, 也可以不用new
 */

case class Person1(name: String, age: Int)


object scala_case_class_001 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person1("zhangsan", 10)
    val p2 = Person1("lisi", 20)
    val p3 = Person1("wangwu", 30)

    val list = List(p1, p2, p3)
    list.foreach { x => {
      x match {
        case Person1("zhangsan", 10) => println("zhangsan")
        case Person1("lisi", 20) => println("lisi")
        case _ => println("no match")
      }
    }
    }
  }
}
