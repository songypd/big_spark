package com.scala.learn.function

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yuanpeng.song on 2018/8/28.
  */
object function_002 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("function_002")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(List("hello me", "hello you", "hello she", "hello he"), 2);
    val rdd2 = rdd1.flatMap(_.split(" "))
    val rdd3 = rdd2.map((_, 1))
    rdd3.groupByKey().map(x => (x._1, x._2.sum)).foreach(println)


    //    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), 4)
    //    rdd1.groupBy(x=>if(x>4) "1" else "0").foreach(println)
    //分区时最小粒度，在不产生shuffle的情况下不能对分去做任何处理
    //对分区进行操作，例如减少stage
    //    对数据集有调整功能
    // coalesce(),repartition()、sortBy()
    //    抽样（对数据产生感知，数据规则RangePartitioner）sample()
    // -》排序的规则-》全排序

    //        coalesce(numPartitions: Int, shuffle: Boolean = false)
    //        val rdd2 = rdd1.coalesce(2,false)


    //     sample(withReplacement: Boolean,fraction: Double,seed: Long = Utils.random.nextLong)
    //    val rdd1 = sc.parallelize(1 to 100)
    //    rdd1.sample(false, 0.12, 1111).foreach(println)
    //    collect() 为action算子，会调起runJob


  }
}
