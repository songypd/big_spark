package com.scala.learn.spark_wordcount

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yuanpeng.song on 2018/8/5.
  */
object wordcount_001 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("wordcount")

    val sc = new SparkContext(conf)

    val lines = sc.textFile("./file/wordcount.txt")

    val words = lines.flatMap(x => x.split(" "))

    val pairwords = words.map(x => new Tuple2(x, 1))

    val wordCounts = pairwords.reduceByKey((a: Int, b: Int) => a + b)

//    wordCounts.saveAsTextFile("./output_001")

//    val sort = wordCounts.sortBy(_._2,false).foreach(println)//降序
    val sort = wordCounts.sortBy(_._2,true).foreach(println)//升序
    println("word_count_success_end")
  }
}

object wordcount_002 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    //在conf中可以决定spark的运行方式
    conf.setMaster("local").setAppName("jingjian_wordcount")
//    val sc = new SparkContext(conf)

//    new SparkContext(conf).textFile("./file/wordcount.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).saveAsTextFile("./output_002")
    new SparkContext(conf).textFile("./file/test.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).foreach(println)
    println("word_count_success_end")
//    while(true){
//
//    }
  }
}
