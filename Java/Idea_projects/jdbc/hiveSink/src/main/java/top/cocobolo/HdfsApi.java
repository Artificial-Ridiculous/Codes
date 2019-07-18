package top.cocobolo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class HdfsApi {
    public static void main(String[] args){
        try{
            System.setProperty("hadoop.home.dir","C:\\hadoop" );
            String fileName = "/hive/test.txt";
//            Configuration conf = new Configuration();
//            conf.set("fs.defaultFS", "hdfs://192.168.229.129:9000");
//            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//            FileSystem fs = FileSystem.get(conf);

            FileSystem fileSystem = null;
            // 获取一个具体的文件系统对象
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://192.168.229.129:9000");
            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");  // 否则报java.io.IOException: No FileSystem for scheme: hdfs
            fileSystem = FileSystem.get(
                    // 创建一下HDFS文件系统的访问路径，就是Hadoop配置文件中的core-sit.xml中的HDFS文件系统的所在机器
                    new URI("hdfs://192.168.229.129:9000"),
                    // 创建一个Hadoop的配置文件的类
                    conf,
                    // 就是Linux启动的用户名
                    "lz");
            if(fileSystem.exists(new Path(fileName))){
                System.out.println("文件存在");
            }else{
                System.out.println("文件不存在");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}