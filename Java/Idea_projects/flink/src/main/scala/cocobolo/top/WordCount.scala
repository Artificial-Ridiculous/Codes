package top.cocobolo

import org.apache.flink.streaming.api.scala._


object WordCount {

  def main(args: Array[String]) {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    // get input data
    val text = env.fromElements("flink has Stateful Computations over Data Streams")

    val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .keyBy(0)
      .sum(1)

    counts.print()

    env.execute("Streaming WordCount")
  }
}
