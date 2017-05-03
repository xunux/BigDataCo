import org.apache.spark.{SparkConf, SparkContext}
//原始数据格式：zhangsan	lisi	lisi	zhangsan	wangwu
object WholeWordCount {
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val textRDD = sc.textFile("D:\\david_work\\scala_work\\scala_mro_parser\\src\\wc.txt")
    val words = textRDD.flatMap { x => x.split("\t") };
    println("words count distinct"+words.distinct().count()) 
    println("words count "+words.count()) 
    val tmpRdd = textRDD.filter(_.contains("zhang"))
    println("contains str words count "+tmpRdd.count())
  }
}
