package com.scala.learn.sprakSql

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SQLContext, SaveMode}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * Created by yuanpeng.song on 2018/9/17.
  * 读取mysql数据数据
  * 生成数据插入mysql中
  */

;

object sparkSql_demo_003 {
  def main(args: Array[String]): Unit = {
    //与mysql的交互
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("mysql")

    /**
      * 配置join或者聚合操作shuffle数据时分区的数量--spark默认为200个线程-》executor
      */
    conf.set("spark.sql.shuffle.partitions", "1");

    val sc = new SparkContext(conf)
    val sql = new SQLContext(sc)

    val line = sc.textFile("./file/sparkSql/normal")
    import sql.implicits._
    //读取普通的rdd->两种方式
    println("__________________________d1___________________________________")
    val d1 = line.map(_.split(",")).map(p => person(p(4), p(3), p(0), p(2), p(1), p(5).toInt)).toDF()
    //    d1.show()
    /**
      * 第一种方式读取MySql数据库表，加载为DataFrame
      */
    println("_______________________第一种查询方式___________________")
    val options = new mutable.HashMap[String, String]()
    options.put("url", "jdbc:mysql://node05:3306/spark")
    options.put("driver", "com.mysql.jdbc.Driver")
    options.put("user", "root")
    options.put("password", "123456")
    options.put("dbtable", "test_001")
    val query_001 = sql.read.format("jdbc").options(options).load()
    //    query_001.show()
    query_001.registerTempTable("q1")
    /**
      * 第二种方式读取MySql数据表加载为DataFrame
      */
    println("_______________________第二种查询方式___________________")
    val reader = sql.read.format("jdbc")
    reader.option("url", "jdbc:mysql://node05:3306/spark")
    reader.option("driver", "com.mysql.jdbc.Driver")
    reader.option("user", "root")
    reader.option("password", "123456")
    reader.option("dbtable", "test_002")
    val query_002 = reader.load()
    query_002.registerTempTable("q2")
    //    query_002.show() //-->默认20条
    val res_join = sql.sql("select count(1) as count from q1 join q2 where q1.name = q2.name")
    res_join.show()
    /**
      * 将DataFrame结果保存到Mysql中
      */
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123456")
    /**
      * SaveMode:
      * Overwrite：覆盖
      * Append:追加
      * ErrorIfExists:如果存在就报错
      * Ignore:如果存在就忽略
      *
      */
    //    d1.registerTempTable("d")
    //    val res = sql.sql("select * from d")
    //    res.printSchema()
    //    res.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://node05:3306/spark", "test_002", properties)
    sql.clearCache()
    sc.stop()
  }
}