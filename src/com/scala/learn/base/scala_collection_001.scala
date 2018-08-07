package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/6.
  * 集合；
  * array、list、set、map、元组
  */

;


/**
  * 数组；
  * 创建数组、遍历数组、创建一维数组，二维数组、数组中的方法举例
  */
object scala_collection_001 {

  /**
    * 创建数组两种方式：
    * 1.new Array[String](3)
    * 2.直接Array
    */

  var ar_01 = Array[Int](10)
  var ar_02 = Array[Int](1, 2, 3, 4, 5)

  //  println(ar_02.length)


  def main(args: Array[String]): Unit = {
    ar_02.foreach(x => println(x))
    ar_02.foreach(println)


    /**
      * 创建二维数组和遍历
      */
    val arr3 = new Array[Array[String]](3)
    arr3(0) = Array("1", "2", "3")
    arr3(1) = Array("4", "5", "6")
    arr3(2) = Array("7", "8", "9")
    for (i <- 0 until arr3.length) {
      for (j <- 0 until arr3(i).length) {
        print(arr3(i)(j) + "	")
      }
      println()
    }

    var count = 0
    for (arr <- arr3; i <- arr) {
      if (count % 3 == 0) {
        println()
      }
      print(i + "	")
      count += 1
    }

    arr3.foreach { arr => {
      arr.foreach {
        println
      }
    }
    }


    val arr4 = Array[Array[Int]](Array(1, 2, 3), Array(4, 5, 6))
    arr4.foreach { arr => {
      arr.foreach(i => {
        println(i)
      })
    }
    }
    println("-------")
    for (arr <- arr4; i <- arr) {
      println(i)
    }


  }

}

/**
  * list
  * 创建、遍历、方法举例
  */
object scala_collection_list {

  /*创建*/
  /*Nil长度为0的list*/
  val list_01 = List(1, 2, 3, 4)

  /*遍历-foreach、for*/
  list_01.foreach(println)

  list_01.+:("hello ").foreach(println) //向前添加
  list_01 :+ (" boy!").foreach(println) //按""分开单词向前添加
  list_01.:+(" boy!").foreach(println) //向后添加


  def fun_01(): Unit = {

  }


  /**
    * 3.list方法举例
    * filter:过滤元素
    * count:计算符合条件的元素个数
    * map：对元素操作
    * flatmap ：压扁扁平,先map再flat
    */

  println("--------filter_01---------")
  val list_02 = list_01.filter(x => x > 3)
  list_02.foreach(println)
  println("--------filter_02---------")
  list_01.filter(_ > 3).foreach(println)
  println("--------count_01---------")
  val val_01 = list_01.count(_ > 3)
  println(val_01)
  println("--------count_02---------")
  println(list_01.count(_ > 3))
  println("-----------map_01-------------")
  val list_03 = list_01.map(_ + 1)
  list_03.foreach(println)
  println("-------------------------map_02")
  list_01.map(_ + 1).foreach(println)
  println("----------flatmap_01------------")
  list_01.map(_ + " " + "hello!").flatMap(_.split(" ")).foreach(println)

  println("获取list的第一个元素")
  println(list_01.head)

  def main(args: Array[String]): Unit = {

  }
}

object scala_collection_set {
  //创建
  val set1 = Set(1, 2, 3, 4, 4)
  val set2 = Set(1, 2, 5)
  //遍历
  //注意：set会自动去重
  set1.foreach {
    println
  }
  for (s <- set1) {
    println(s)
  }
  println("*******")
  /**
    * 方法举例
    */

  println("---------交集---------inersect--或者-&----")
  val set3 = set1.intersect(set2)
  set3.foreach {
    println
  }
  val set4 = set1.&(set2)
  set4.foreach {
    println
  }
  println("*******")
  //差集
  println("----------差集-------diff-----")
  set1.diff(set2).foreach {
    println
  }
  println("----------差集------- &~ -----")
  set1.&~(set2).foreach {
    println
  }
  //子集
  println("-----------判断是否是子集subsetof---------------")
  set1.subsetOf(set2)

  //最大值
  println(set1.max)
  //最小值
  println(set1.min)
  println("****")

  //转成数组，list
  println("--------------toArray转换成数组array")
  set1.toArray.foreach {
    println
  }
  println("****")
  println("--------------tolist转换成list----")
  set1.toList.foreach {
    println
  }

  //mkString
  println("转成字符串：mkString(“~”)")
  println(set1.mkString)
  println(set1.mkString("\t"))

  def main(args: Array[String]): Unit = {

  }

}


/**
  * map
  */
object scala_collection_map {

  /*1.map创建
  Map（1 –>”bjsxt’）
  Map((1,”bjsxt”))
  注意：创建map时，相同的key被后面的相同的key顶替掉，只保留一个*/

  val map = Map(
    "1" -> "bjsxt",
    2 -> "shsxt",
    (3, "xasxt")
  )

  /*3.遍历map
  for,foreach*/
  map.foreach(println(_))


  /*2.获取map的值
  map.get(“1”).get
  map.get(100).getOrElse(“no value”)：如果map中没有对应项，赋值为getOrElse传的值。*/

  println(map.get("1").get)
  val result = map.get(8).getOrElse("no value")
  println(result)

  /*4.遍历key
  map.keys*/

  map.keys.foreach(println(_))

  /* 5.遍历value
   map.values*/
  map.values.foreach(println(_))

  /* 6.合并map
   ++  例：map1.++(map2)  --map1中加入map2
   ++:  例：map1.++:(map2) –map2中加入map1
   注意：合并map会将map中的相同key的value替换*/
  val map_01 = Map(
    (1, 2),
    (2, 3),
    (3, 4)
  )
  val map_02 = Map(
    (1, "wo"),
    (4, "5"),
    (5, 6)
  )

  map_01.++(map_02).foreach(print)
  println()
  map_01.++:(map_02).foreach(print)
  println()


  println("方法举例")

  /*7.map中的方法举例
  filter:过滤，留下符合条件的记录
  count:统计符合条件的记录数
  contains：map中是否包含某个key
  exist：符合条件的记录存在不存在*/

  map_01.filter(_._1 > 1).foreach(println)
  map_02.filter(_._2.equals("wo")).foreach(println)

  println("---count---")
  println(map_01.count(_._1 >= 2))
  println("---contains---")
  println(map_02.contains(5))
  println(map_01.contains(5))
  println("---exist---")
  println(map_01.exists(_._2.equals("wo")))


  def main(args: Array[String]): Unit = {

  }

}


/**
  * 元组
  */
object scala_collection_Tuple {


  /* 1.元组定义
   与列表一样，与列表不同的是元组可以包含不同类型的元素。元组的值是通过将单个的值包含在圆括号中构成的。
   2.创建元组与取值
   val  tuple = new Tuple（1） 可以使用new
   val tuple2  = Tuple（1,2） 可以不使用new，也可以直接写成val tuple3 =（1,2,3）
   取值用”._XX” 可以获取元组中的值
   注意：tuple最多支持22个参数*/


  //创建，最多支持22个
  val tuple = new Tuple1(1)
  val tuple2 = Tuple2("zhangsan", 2)
  val tuple3 = Tuple3(1, 2, 3)
  val tuple4 = (1, 2, 3, 4)
  val tuple18 = Tuple18(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
  val tuple22 = new Tuple22(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)

  //使用
  println(tuple2._1 + "\t" + tuple2._2)
  val t = Tuple2((1, 2), ("zhangsan", "lisi"))
  println(t._1._2)


  /* 3.元组的遍历
   tuple.productIterator得到迭代器，进而遍历*/
  println("元组的遍历")
  tuple3.productIterator.foreach(println)

  val tupleIterator = tuple22.productIterator
  while(tupleIterator.hasNext){
    println(tupleIterator.next())
  }

  /*4.swap,toString方法
  注意：swap元素翻转，只针对二元组*/

  /**
    * 方法
    */
  //翻转，只针对二元组
  println(tuple2.swap)

  //toString
  println(tuple3.toString())


  def main(args: Array[String]): Unit = {

  }
}









