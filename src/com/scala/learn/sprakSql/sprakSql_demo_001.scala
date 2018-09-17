package com.scala.learn.sprakSql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yuanpeng.song on 2018/9/16.
  * 读取json的rdd
  */


object sprakSql_demo_001 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("sql_json")
    val sc = new SQLContext(new SparkContext(conf))
    //读取json的两种方式；
    val d1 = sc.read.json("./file/sparkSql/Json") //-》不能读取存在嵌套形式的json文件
    val d2 = sc.read.format("JSON").load("./file/sparkSql/Json")
    d1.show()//读取元数据-》会按照ascil进行排序
//    d2.show()
//    d1.foreach(println)
    d1.printSchema()
    d1.registerTempTable("test")
    val res = sc.sql("select * from test")
    res.foreach(println)
  }
}
