// package top.cocobolo

object Upper{
    def main(args:Array[String]): Unit = {
        args.map(s => s.toUpperCase).foreach(println(_))
    }
}