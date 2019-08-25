package top.cocobolo


import org.apache.flink.streaming.api.scala._
import org.apache.flink.api.scala.ExecutionEnvironment




object WordCountStream {

  def main(args: Array[String]) {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(2)


    // get input data
    // val text = env.socketTextStream("localhost",9999)

    val text = env.readTextFile("/home/lz/test/flink.txt")

    val counts = text.flatMap { _.toLowerCase.split("\\W+").filter { _.nonEmpty } }
      .map { (_, 1) }
      .keyBy(0)
      .reduce((a,b)=>(a._1,a._2+b._2))


    counts.print()
    // 执行流式任务并且指定名称
//    env.execute("Streaming WordCount")
    println(env.getExecutionPlan)
  }
}


object WordCountBatch {

  def main(args: Array[String]) {
    val env = ExecutionEnvironment.getExecutionEnvironment
//    env.setParallelism(2)

    // get input data
    val text1 = env.readTextFile("/home/lz/test/flink.txt")
    val text2 = env.readTextFile("/home/lz/test/flink.txt")
    val text3 = text1.union(text2)

    val counts = text1.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .groupBy(0)
      .sum(1)

    counts.print()


  }
}