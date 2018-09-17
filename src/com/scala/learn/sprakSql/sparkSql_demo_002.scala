package com.scala.learn.sprakSql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{StringType, StructField, StructType}


/**
  * Created by yuanpeng.song on 2018/9/16.
  */

;

object sparkSql_demo_002 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("sql_json")
    val sc = new SparkContext(conf)
    val sql = new SQLContext(sc)
    val line = sc.textFile("./file/sparkSql/normal")


    //在scala中使用反射方式，进行RDD到DataFrame的转换，需要手动导入一个隐式转换
    import sql.implicits._
    //读取普通的rdd->两种方式
    println("__________________________d1___________________________________")
    val d1 = line.map(_.split(",")).map(p => person(p(4), p(3), p(0), p(2), p(1), p(5).toInt)).toDF()
    d1.show()
    d1.registerTempTable("normal")
    sql.sql("select * from normal where sal > 20000").foreach(println)
    //反射-->通过反射推断schema信息
    //通过动态创建schema
    //先将数据文件转换为RDD，然后对数据文件中具体数据定义StructType类型的schema
    //最后通过SQLContext的createDataFrame方法绑定schema到行数据上。
    //        val schemaStr = "name,job_number,age,gender,deptno,sal"
    println("__________________________d2___________________________________")
    val schemaStr = "name,job_number,age,gender,deptno"
    val schema = StructType {
      schemaStr.split(",").map(StructField(_, StringType, true))
    }
    val row = line.map(_.split(",")).map(e => Row(e(4), e(3), e(0), e(2), e(1)))
    val d2 = sql.createDataFrame(row, schema)
    d2.show()
    d2.registerTempTable("d2")
    sql.sql("select * from d2 where gender = 'male'").foreach(println)
  }
}

case class person(name: String, job_number: String, age: String, gender: String, deptno: String, sal: Int)
