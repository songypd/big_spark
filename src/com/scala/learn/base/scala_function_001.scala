package com.scala.learn.base

import java.util.Date

/**
  * Created by yuanpeng.song on 2018/8/6.
  *
  * 函数
  */

;

/**
  * 知识点
  * 函数；有参函数、无参函数
  * 注意点；
  * 函数定义语法 用def来定义
  * 可以定义传入的参数，要指定传入参数的类型
  * 方法可以写返回值的类型也可以不写，会自动推断，有时候不能省略，必须写，比如在递归函数中或者函数的返回值是函数类型的时候
  * scala中函数有返回值时，可以写return，也可以不写return，会把函数中最后一行当做结果返回。当写return时，必须要写函数的返回值。
  * 如果返回值可以一行搞定，可以将{}省略不写
  * 传递给方法的参数可以在方法中使用，并且scala规定方法的传过来的参数为val的，不是var的
  * 如果去掉方法体前面的等号，那么这个方法返回类型必定是Unit的。这种说法无论方法体里面什么逻辑都成立，
  * scala可以把任意类型转换为Unit.假设，里面的逻辑最后返回了一个string，那么这个返回值会被转换成Unit，并且值会被丢弃。
  */

object scala_function_001 {

  /*2，递归函数*/
  def fun_001(i: Int): Int = {
    if (i == 1) i
    else i * fun_001(i - 1)
  }

  //  println(fun_001(3))

  /*3.包含参数默认值的函数*/
  /*
  注意点；
      默认值的函数中，如果传入的参数个数与函数定义相同，则传入的数值会覆盖默认值。
      如果不想覆盖默认值，传入的参数个数小于定义的函数的参数，则需要指定参数名称。
   */
  def fun_002(i: Int = 2, j: Int = 3) = {
    i * j
  }

  //  println(fun_002(3))//9
  //  println(fun_002(4,5))//20
  //  println(fun_002(j=4))//8

  /*4.可变参数个数的函数*/
  /*
  多个参数用逗号分开
   */
  def fun_003(i: Int*) = {
    var sum = 0
    for (j <- i) {
      sum += 1
    }
    //    i.foreach(sum = sum + 1)
    sum
  }

  //  println(fun_003(1,1,1))

  /*
  *匿名函数
  * 1.有参匿名函数
  * 2.无参匿名函数
  * 3.有返回值的匿名函数
  *
  * 可以将匿名函数返回给val定义的值
  * 匿名函数不能显式声明函数的返回类型
  *
  * */

  //有参数匿名函数
  val value1 = (a: Int) => {
    println(a)
  }
  //  value1(1)

  //无参数匿名函数
  val value2 = () => {
    println("无参数匿名函数")
  }
  //  value2()

  //有返回值的匿名函数
  val value3 = (a: Int, b: Int) => {
    a + b
  }

  //  println(value3(4,4))

  /**
    * 嵌套函数
    * 例如：嵌套函数求5的阶乘
    */
  def fun_003(num:Int)={
    def fun6(a:Int,b:Int):Int={
      if(a == 1){
        b
      }else{
        fun6(a-1,a*b)
      }
    }
    fun6(num,1)
  }
//  println(fun_003(5))

  /**
    * 偏应用函数
    */
  def log(date :Date, s :String)= {
    println("date is "+ date +",log is "+ s)
  }

  val date = new Date()
  log(date ,"log1")
  log(date ,"log2")
  log(date ,"log3")

  //想要调用log，以上变化的是第二个参数，可以用偏应用函数处理
  val logWithDate = log(date,_:String)
  logWithDate("log11")
  logWithDate("log22")
  logWithDate("log33")

  /**
    * 高阶函数
    * 函数的参数是函数		或者函数的返回是函数		或者函数的参数和返回都是函数
    */

  //函数的参数是函数
  def hightFun(f : (Int,Int) =>Int, a:Int ) : Int = {
    f(a,100)
  }
  def f(v1 :Int,v2: Int):Int  = {
    v1+v2
  }

  println(hightFun(f, 1))

  //函数的返回是函数
  //1，2,3,4相加
  def hightFun2(a : Int,b:Int) : (Int,Int)=>Int = {
    def f2 (v1: Int,v2:Int) :Int = {
      v1+v2+a+b
    }
    f2
  }
  println(hightFun2(1,2)(3,4))

  //函数的参数是函数，函数的返回是函数
  def hightFun3(f : (Int ,Int) => Int) : (Int,Int) => Int = {
    f
  }
  println(hightFun3(f)(100,200))
  println(hightFun3((a,b) =>{a+b})(200,200))
  //以上这句话还可以写成这样
  //如果函数的参数在方法体中只使用了一次 那么可以写成_表示
  println(hightFun3(_+_)(200,200))

  /**
    * 柯里化函数
    * 可以理解为高阶函数的简化
    */
  def fun7(a :Int,b:Int)(c:Int,d:Int) = {
    a+b+c+d
  }
  println(fun7(1,2)(3,4))


  def main(args: Array[String]): Unit = {

  }

}
