package com.scala.learn.test


/**
  *
  * @author yuanpeng.song
  * @create 2018/8/4
  * @since 1.0.0
  *
  *        流程控制
  *        if 最后如果不是方法执行，类似return（将值赋给变量）
  *        for循环
  *        步进
  *        迭代 i in 'seq 10'
  *        迭代的时候变量不可修改是val修饰的
  *        哨兵模式
  *
  *        集合
  *
  *
  */


/**
  * 函数定义语法 用def来定义
  *
  * 可以定义传入的参数，要指定传入参数的类型
  *
  * 方法可以写返回值的类型也可以不写，会自动推断，有时候不能省略，必须写，比如在递归函数中或者函数的返回值是函数类型的时候。
  *
  * scala中函数有返回值时，可以写return，也可以不写return，会把函数中最后一行当做结果返回。当写return时，必须要写函数的返回值。
  *
  * 如果返回值可以一行搞定，可以将{}省略不写
  *
  * 传递给方法的参数可以在方法中使用，并且scala规定方法的传过来的参数为val的，不是var的。
  *
  * 如果去掉方法体前面的等号，那么这个方法返回类型必定是Unit的。这种说法无论方法体里面什么逻辑都成立，
  * scala可以把任意类型转换为Unit.假设，里面的逻辑最后返回了一个string，那么这个返回值会被转换成Unit，并且值会被丢弃。
  **/
object Test_002 {
  //to和until 的用法（不带步长，带步长区别）Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(1 to 10)
  //带步长   Range(1, 3, 5, 7, 9)
  println(1 to(10, 2))
  //Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(1 until 10)
  //Range(1, 3, 5, 7, 9)
  println(1 until(10, 2))
}

object test_003 {
  def main(args: Array[String]): Unit = {
    var count = 0
    for (i <- 1 to 10) {
      print(i: Int)
      print("--")
      count += i
      println(count)
    }
    println("/*哨兵模式  --守卫    循环+判断*/")
    /*哨兵模式  --守卫    循环+判断*/
    for (i <- 1 to 10 if (i % 2 == 0)) {
      println(i)
    }

    println("9x9 乘法表")
    for (i <- 1 to 9) {
      for (j <- 1 to 9) {
        if (j <= i) print(j + "*" + i + "=" + (j.*(i)) + "\t")
        if (j == i) println();
      }
    }
    //9x9 乘法表
    println("嵌套循环")
    for (i <- 1 to 9; j <- 1 to 9) {
      if (j <= i) print(j + "*" + i + "=" + (j.*(i)) + "\t")
      if (j == i) println();
    }
    //嵌套循环
    println("嵌套循环+守卫模式")
    for (i <- 1 to 9 if (i % 2 == 0); j <- 1 to 9) {
      if (j <= i) print(j + "*" + i + "=" + (j.*(i)) + "\t")
      if (j == i) println();
    }

  }

}


object test_004 {


  def fun_001(): Unit =
    println("hello world")


  def fun_002(msg: String): String = {
    //传递给方法的参数可以在方法中使用，并且scala规定方法的传过来的参数为val的，不是var的。
    //    msg = "new "
    var end = msg + "++++++world"
    end
  }

  //递归函数
  println("递归函数测试")

  def fun_digui(i: Int): Int = {
    if (i == 1) {
      i
    } else {
      i * fun_digui(i - 1)
    }
  }


  //遍历
  def fun_005(i: Int*): Unit = {
    println("遍历的三种方式---")
    i.foreach(x => println(x + "-"))
    i.foreach(println(_))
    i.foreach(println)
  }

  fun_005(1, 2, 3, 4, 5)

  //  fun_001()
  //  println(fun_002("hello"))
  //  println(fun_digui(2))


  def main(args: Array[String]): Unit = {

  }
}

/**
  * 循环、函数
  * scala中不能使用count++，count—只能使用count = count+1 ，count += 1
  */
object test_005 {


  /**
    * 变长参数列表
    * 多个参数用逗号分开
    */
  def fun_001(i: Int*): Unit = {
    println("遍历的三种方式")
    var sum = 0
    i.foreach(x => print(x))
    //    i.foreach(x =>println(sum+x))
    i.foreach(println(_))
    i.foreach(println)
  }

  fun_001(1, 2, 3, 4, 5)
  println("-----------------")
  fun_001(1, 2, 3)

  /**
    * 包含默认参数值的函数
    * 注意：
    * 1.默认值的函数中，如果传入的参数个数与函数定义相同，则传入的数值会覆盖默认值
    * 2.如果不想覆盖默认值，传入的参数个数小于定义的函数的参数，则需要指定参数名称
    */
  def fun_002(a: Int = 10, b: Int = 10) = {
    print("a=" + a + "_b=" + b + "-----")
    a + b
  }


  def fun_003(a: Int = 10, b: Int) = {
    print("a=" + a + "_b=" + b + "-----")
    a + b
  }

  //  println(fun_002(b=1))

  /**
    * 匿名函数
    * 1.有参数匿名函数
    * 2.无参数匿名函数
    * 3.有返回值的匿名函数
    * 注意：
    * 可以将匿名函数返回给定义的一个变量
    */
  println("-------------匿名函数---------------")
  var f_001 = (i: Int, j: Int) => {
    println(i + j)
    println("有参数匿名函数")

  }

  //    f_001(2, 3)

  var f_002 = () => println("无参数匿名函数")


//  println(fun_002())
  f_002()
  /*嵌套函数--》函数的嵌套-----闭包*/
  println("----------嵌套函数 -------------")
  /*偏应用函数*/
  /*高阶函数*/
  //显式函数、匿名函数
  //函数作为参数、函数作为返回值、函数即作为参数有作为返回值
  /*柯里化函数*/
  def main(args: Array[String]): Unit = {

  }
}

object test_006 {

  /**
    *
    * pipeline   管道 迭代器模式  flatMap+map
    *
    * 算子
    * map（做映射（函数输入），返回迭代器Iterator）、flatMap
    *
    * 迭代器--懒执行
    *
    * 闭包
    *
    *
    *
    *
    */

  def test_001: Unit = {
    val data = List[String]("hello sxt", "hello bjsxt", "hello shsxt")
    val iter1 = data.iterator
    val iter2 = iter1.flatMap((x) => { //进来一条>多条
      x.split(" ")
    }
    )
    val iter3 = iter2.map { (x) => (x, 1) }
    while (iter3.hasNext)
      println(iter3.next)

  }

  test_001

  def main(args: Array[String]): Unit = {

  }
}



















