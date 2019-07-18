package top.cocobolo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class Chapter3 {
    public static void main(String[] args) {
        try {
            String filename = "test";

            Configuration conf = new Configuration();
            conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(new URI("hdfs://tf-ubuntu:9000"),conf,"lz");
            if(fs.exists(new Path(filename))){
                System.out.println("文件存在");
            }else{
                System.out.println("文件不存在");
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}