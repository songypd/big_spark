package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/6.
  * 类和对象
  */

;

/**
  * 知识点
  * 类和对象；
  *   建议类名首字母大写 ，方法首字母小写，类和方法命名建议符合驼峰命名法。
  *   scala 中的object是单例对象，相当于java中的工具类，可以看成是定义静态的方法的类。object不可以传参数。另：Trait不可以传参数
  *   scala中的class类默认可以传参数，默认的传参数就是默认的构造函数。重写构造函数的时候，必须要调用默认的构造函数。
  *   class 类属性自带getter ，setter方法。
  *   使用object时，不用new,使用class时要new ,并且new的时候，class中除了方法不执行，其他都执行。
  *   如果在同一个文件中，object对象和class类的名称相同，则这个对象就是这个类的伴生对象，这个类就是这个对象的伴生类。可以互相访问私有变量。
  *
  */




object scala_class_001 {

  /*if_else*/
  def fun_001(i:Int): Unit ={
    if (i<=10) println("小个子")
    else println("大哥哥")
  }

  /*for_不加步长*/
  def fun_002(i:Int) ={
    for (j <- 1 to i) fun_001(j)
  }
  /*for_加步长*/
  def fun_002_001(i:Int) ={
    for (j <- 1 to (i,2)) fun_001(j)
  }

  /*for_加判断*/
  def fun_003(i:Int) ={
    for (j <- 1 to (i,12);if (j%2==0)) fun_001(j)
  }
  /*for循环用yield 关键字返回一个集合*/
 def fun_004(i:Int) ={
    for (j <- 1 to (i,12);if (j%2==0)) yield j

  }

  /*while*/
  def fun_005(i:Int): Unit ={
    while(i<10)println(i)
  }

  fun_005(9)

  def main(args: Array[String]): Unit = {

  }

}
