package top.cocobolo;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * @auther lz
 * @create 2019-07-19 14:51
 */

public class HiveSinkBatch extends RichSinkFunction<Transaction> {
    private Connection hiveConn;
    private FileSystem hdfs;
    private String uuid;
    private String dst;
    private Path dstPath;
    private FSDataOutputStream outputStream;
    private int objectCounter;
    private ArrayList<Transaction> transactionArrayList;


    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        System.out.println("opennnnnnnnnnnnnnnnnnn");
        hiveConn = GetConnection.getHiveConnection();
        hdfs = GetConnection.getHDFSFileSystem();
        objectCounter = 0;
        transactionArrayList = new ArrayList<Transaction>();
    }

    @Override
    public void close() throws Exception {
        super.close();
        System.out.println("closeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        if (outputStream != null) {
            outputStream.close();
        }
        if (hiveConn != null) {
            hiveConn.close();
        }
        if (hdfs != null) {
            hdfs.close();
        }
    }

    @Override
    public void invoke(Transaction transaction, Context context) throws IOException, SQLException {
        transactionArrayList.add(transaction);
        objectCounter += 1;
        System.out.println("invokeeeeeeeeeeeeeeeeeeeee and objectCounter = "+ objectCounter);
        if(objectCounter >= 5){
            uuid = UUID.randomUUID().toString().replaceAll("-", "");
            dst = "/hive/"+ uuid + ".txt";
            System.out.println("oooooooooooooooooobjectCounter >= 10");
            WriteToHDFS.writeToHDFS(transactionArrayList, hdfs, hiveConn, dst, dstPath, outputStream);
            NotifyHiveToLoad.load(dst, hiveConn);
            objectCounter = 0;
            transactionArrayList.clear();
        }
    }

    public static void main(String[] args) {
//        hiveConn = GetConnection.getHiveConnection();
//        hdfs = GetConnection.getHDFSFileSystem();
//        Transaction transaction = Transaction.getRandomTransaction();
//        transaction.
    }
}