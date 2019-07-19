package top.cocobolo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @auther lz
 * @create 2019-07-19 15:00
 */
public class GetConnection {
    public static Connection getHiveConnection() {
        Connection conn = null;
        try {
            String jdbc = "org.apache.hive.jdbc.HiveDriver";
            String url = "jdbc:hive2://192.168.229.129:10000/test";
            String user = "lz";  // 重要！此处必须填入具有HDFS写入权限的用户名，比如hive文件夹的owner
            String password = "";
            Class.forName(jdbc);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static FileSystem getHDFSFileSystem()  {
        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        URI uri = null;
        try {
            uri = new URI("hdfs://tf-ubuntu:9000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        FileSystem fs = null;
        try {
            fs = FileSystem.get(uri,conf,"lz");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        String filename = "test";
//        if(fs.exists(new Path(filename))){
//            System.out.println("文件存在");
//        }else{
//            System.out.println("文件不存在");
//        }
//        fs.close();

        return fs;
    }
}
