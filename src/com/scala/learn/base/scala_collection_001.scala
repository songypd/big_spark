package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/6.
  * 集合；
  *     array、list、set、map、元组
  */

;


/**
  * 数组；
  *   创建数组、遍历数组、创建一维数组，二维数组、数组中的方法举例
  */
object scala_collection_001 {

  /**
    * 创建数组两种方式：
    * 1.new Array[String](3)
    * 2.直接Array
    */

  var ar_01 = Array[Int](10)
  var ar_02 = Array[Int](1,2,3,4,5)

//  println(ar_02.length)


  def main(args: Array[String]): Unit = {
    ar_02.foreach(x=>println(x))
    ar_02.foreach(println)


    /**
      * 创建二维数组和遍历
      */
    val arr3 = new Array[Array[String]](3)
    arr3(0)=Array("1","2","3")
    arr3(1)=Array("4","5","6")
    arr3(2)=Array("7","8","9")
    for(i <- 0 until arr3.length){
      for(j <- 0 until arr3(i).length){
        print(arr3(i)(j)+"	")
      }
      println()
    }

    var count = 0
    for(arr <- arr3 ;i <- arr){
      if(count%3 == 0){
        println()
      }
      print(i+"	")
      count +=1
    }

    arr3.foreach { arr  => {
      arr.foreach { println }
    }}


    val arr4 = Array[Array[Int]](Array(1,2,3),Array(4,5,6))
    arr4.foreach { arr => {
      arr.foreach(i => {
        println(i)
      })
    }}
    println("-------")
    for(arr <- arr4;i <- arr){
      println(i)
    }




  }

}
