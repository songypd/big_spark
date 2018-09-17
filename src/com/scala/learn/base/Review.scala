package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/9/15.
  */


object Review {


  def main(args: Array[String]): Unit = {
    //    this.forCodeReview()
    //    println(funTest(2, "woshi"))
    //    println(this.diguifun(3))
    //匿名函数
    //    val fun = (x:Int,y:Int) =>println(x+y)
    //
    //    fun(1,3)
    //    println(this.gaojiehanshu(f,2,3))
    println(gaojihanshu(f,1,2)(3))
  }

  def gaojihanshu(f: (Int, Int) => Int, x: Int, y: Int): (Int) =>String = {
    val a = f(x, y)

    def f_01(c: Int): String = {
      a +"-------" + c
    }

    f_01
  }

  def gaojiehanshu(f: (Int, Int) => Int, x: Int, y: Int): Int= {
    f(x, y)
  }

  def f(x: Int, y: Int): Int = {
    x + y
  }

  def funTest(x: Int, y: String): String = {
    var z = y.split("");
    z(x)
  }

  /**
    * 如果是递归的话，必须表明返回类型
    *
    * @param x
    */
  def diguifun(x: Int): Int = {
    if (x == 1) {
      x
    } else {
      x * diguifun(x - 1)
    }
  }

  /**
    * 流程控制的练习
    */
  def forCodeReview(): Unit = {
    print(1 to 10)

    print("===============================")
    for (i <- 1 to 10 if (i % 2 == 0)) {
      println(i)
    }
    print("===============================")
    for (i <- 1 to 9) {
      for (j <- 1 to 9) {
        if (j == i) println()
        if (j < i) print(j + " * " + i + " = " + i * j + "\t")
      }
    }
    print("===============================")
    for (i <- 1 to 9; j <- 1 to 9) {
      if (j == i) println()
      if (j < i) print(j + " * " + i + " = " + i * j + "\t")
    }
  }
}
