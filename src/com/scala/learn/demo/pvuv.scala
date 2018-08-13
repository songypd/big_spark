package com.scala.learn.demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yuanpeng.song on 2018/8/12.
  *
  * little demo pv_uv
  *
  * dataDemo;  7.213.213.208	吉林	2018-03-29	1522294977303	1920936170939152672	www.dangdang.com	Login
  */

;

object pvuv {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("pv_uv_demo")
    val sc = new SparkContext(conf)
    //pv
    //    sc.textFile("./file/pvuvdata",10).map(x => ((x.split("\t")(5)), 1)).reduceByKey(_+_).sortBy(_._2).saveAsTextFile("./pvout")
    //    sc.textFile("./file/pvuvdata",10).map(x => ((x.split("\t")(5)), 1)).reduceByKey(_+_).sortBy(_._2,false).take(5).foreach(println)
    //uv
    //    val a = sc.textFile("./file/pvuvdata")
    //    val b = a.map(_.split("\t"))
    //    val c = b.map(x => (x(0) + "_" + x(5), 1))
    //    val d = c.distinct()
    //    val f = d.map(x=>(x._1.split("_")(1),1))
    //    val e = f.reduceByKey(_+_).sortBy(_._2, false)
    //    e.take(5).foreach(println)

    sc.textFile("./file/pvuvdata").map(_.split("\t")).map(x => (x(0) + "_" + x(5), 1)).distinct().map(x => (x._1.split("_")(1), 1))
      .reduceByKey(_ + _).sortBy(_._2, false).take(5).foreach(println)
    while (true) {}
  }
}
