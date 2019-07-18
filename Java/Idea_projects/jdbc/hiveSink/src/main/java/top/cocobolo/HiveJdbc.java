package top.cocobolo;

/**
 * @auther lz
 * @create 2019-07-17 16:35
 */
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;


/**
 * <p>Description: </p>
 * @author kangkaia
 * @date 2017年12月26日 下午1:42:24
 */
public class HiveJdbc {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<List> argList = new ArrayList<>();  // argList = []
        List<String> arg = new ArrayList<>();  // arg = []
        arg.add("12345");  // arg = ["12345"]
        arg.add("m");  // arg = ["12345","m"]
        argList.add(arg);  // argList = [["12345","m"]]
        arg = new ArrayList<>() ;  // arg = []
        arg.add("54321");  // arg = ["54321"]
        arg.add("f");  // arg = ["54321","f"]
        argList.add(arg);  // argList = [["12345","m"], ["54321","f"]]
		System.out.println(argList.toString());
        String dst = "/hive/test.txt";
        createFile(dst,argList);
        loadData2Hive(dst);
    }

    /**
     * 将数据插入hdfs中，用于load到hive表中，默认分隔符是"\001"
     * @param dst HDFS 路径
     * @param argList 待写入的List<List>
     * @throws IOException
     */
    private static void createFile(String dst, List<List> argList) throws IOException, URISyntaxException, InterruptedException {
//        Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);
        FileSystem fs = getfileSystem();
        Path dstPath = new Path(dst); //目标路径
        //打开一个输出流
        FSDataOutputStream outputStream = fs.create(dstPath,true);
        StringBuilder sb = new StringBuilder();
        for(List<String> arg:argList){
            for(String value:arg){
                sb.append(value).append("\001");
            }
            sb.deleteCharAt(sb.length() - 4);//去掉最后一个分隔符
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 2);//去掉最后一个换行符
        byte[] contents =  sb.toString().getBytes();
        outputStream.write(contents);
        outputStream.close();
        fs.close();
        System.out.println("文件创建成功！");

    }

    public static FileSystem getfileSystem() throws IOException, InterruptedException, URISyntaxException {
        // 获取一个具体的文件系统对象
        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://tf-ubuntu:9000"),conf,"lz");
        return fileSystem;
    }


    /**
     * 将HDFS文件load到hive表中
     * @param dst HDFS 路径
     */
    private static void loadData2Hive(String dst) {
//        String JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
//        String CONNECTION_URL = "jdbc:hive2://192.168.229.129:10000/test";
//        String username = "lz";
//        String password = "";
        Connection con = null;

        try {
//            Class.forName(JDBC_DRIVER);
//            con = (Connection) DriverManager.getConnection(CONNECTION_URL,username,password);

            con = HiveSink.getConnection();
            Statement stmt = con.createStatement();

            String sql = " load data inpath '"+dst+"' overwrite into table test ";

            stmt.execute(sql);
            System.out.println("loadData到Hive表成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭rs、ps和con
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
