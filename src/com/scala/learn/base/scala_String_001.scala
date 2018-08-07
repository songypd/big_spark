package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/6.
  * 字符串
  */

;

/**
  * 字符串
  * 1.String
  * 2.StringBuilder 可变
  * 3.string操作方法举例
  *   比较:equals
  *   比较忽略大小写:equalsIgnoreCase
  *   indexOf：如果字符串中有传入的assci码对应的值，返回下标
  */
object scala_String_001 {

  /**
    * String && StringBuilder
    */
  val str = "abcd"//不可变
  val str1 = "ABCD"//不可变
  var s = "abc"//可变

  println(str.indexOf(97))
  println(str.indexOf("b"))

  println(str==str1)
  /**
    * compareToIgnoreCase
    *
    * 如果参数字符串等于此字符串，则返回值 0；
    * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
    * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
    *
    */
  println(str.compareToIgnoreCase(str1))

  val strBuilder = new StringBuilder
  strBuilder.append("abc")
  //    strBuilder.+('d')
  strBuilder+ 'd'
  //    strBuilder.++=("efg")
  strBuilder++= "efg"
  //    strBuilder.+=('h')
  strBuilder+= 'h'
  strBuilder.append(1.0)
  strBuilder.append(18f)
  println(strBuilder)

  println(str.equalsIgnoreCase(str1))




  def main(args: Array[String]): Unit = {

  }
}
