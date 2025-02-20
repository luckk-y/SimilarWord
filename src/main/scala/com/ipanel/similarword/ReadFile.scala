package com.ipanel.similarword

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.slf4j.{Logger, LoggerFactory}

class ReadFile {

  def readCSV(fileName: String, col: String, spark: SparkSession,logger: Logger): DataFrame = {
    logger.info("==================== 读取csv文件 ==========================")
    val cleanFileDF = spark.read.format("csv")
      .option("delimiter", ",")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(fileName)
      .select(col)
    println("输入文件中的数据条数为:   " + cleanFileDF.count())
    logger.info("csv文件读取完成")
    cleanFileDF
  }

  def readTXT(file:String, spark:SparkSession,logger: Logger):DataFrame = {
    logger.info("==================== 读取txt文件 ==========================")
    val txtDF = spark.read.text(file)
    logger.info("txt文件读取完成")
    txtDF
  }

}
