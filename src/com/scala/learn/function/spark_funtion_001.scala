package com.scala.learn.function

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * Created by yuanpeng.song on 2018/8/12.
  */

;

/**
  * 算子
  * map
  * flatmap
  * mappartionswithindex
  * mappartions
  */
object spark_funtion_001 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("testFunction")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(List(
      "hello sxt",
      "hello sxt",
      "hello sxt",
      "hello sxt",
      "hello sxt",
      "hello sxt",
      "hello bjsxt"
    ), 2)
//每迭代出一条数据就会对相关数据进行处理，处理完关闭原有，并重新开启新连接
//    rdd.map(x => {
//      println("connetc  sql ......")
//      println("x: " + x + "select ....")
//      println("close  sql .....")
//
//      "x: " + x + "select ...."
//    }).foreach(println)
//重新复用了上层iterator的方法
  rdd.mapPartitionsWithIndex((index,iter)=>{
    val newIter = new Iterator[String]{
      def hasNext = iter.hasNext
      def next() = iter.next()
    }
    newIter
  },true).foreach(println)
println()
  rdd.mapPartitionsWithIndex((index,iter)=>{
    var list = new ListBuffer[String]
    while (iter.hasNext){
      list.append(iter.next())
    }
    list.iterator
    },true).foreach(println)


    while (true){}

  }



}
