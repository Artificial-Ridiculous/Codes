package top.cocobolo;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * @auther lz
 * @create 2019-07-19 14:51
 */

public class HiveSinkBatch extends RichSinkFunction<Transaction> {
    //全程只需要生成一次
    Connection hiveConn;
    FileSystem hdfs;
    int objectCounter;
    int counterThreshold;
    long interval;
    //    static ArrayList<Transaction> transactionArrayList;
    List<Transaction> transactionArrayList;
    String uuid;
    String dst;
    Path dstPath;
    FSDataOutputStream outputStream;
    boolean batchSatisfied;
    boolean intervalSatisfied;
    Object lock;
    Thread t;

//    long currentMilli;
//    long startMilli;
//    Object lock;
//    Thread t;


    public HiveSinkBatch(int counterThreshold, long interval) throws IOException {
        this.counterThreshold = counterThreshold;
        this.interval = interval;
        hiveConn = GetConnection.getHiveConnection();
        hdfs = GetConnection.getHDFSFileSystem();
        objectCounter = 0;
        transactionArrayList = Collections.synchronizedList(new ArrayList<>());
    }


    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        HiveSinkBatch hiveSinkBatch = new HiveSinkBatch(counterThreshold, interval);
        System.out.println("opennnnnnnnnnnnnnnnnnn");
        t = new Thread(new WriteToHDFS(transactionArrayList, interval), "write线程");
        t.start();
    }


    @Override
    public void invoke(Transaction transaction, Context context) throws IOException, SQLException, InterruptedException {
        synchronized (transactionArrayList) {
            transactionArrayList.add(transaction);
            objectCounter += 1;
            if (objectCounter >= counterThreshold) {
                transactionArrayList.notifyAll();
                transactionArrayList.wait();
            }
        }

//            transactionArrayList.wait();
//            transactionArrayList.add(transaction);
//            objectCounter += 1;
//            notifyAll();

//        currentMilli = System.currentTimeMillis() - startMilli;

//        if(objectCounter >= counterThreshold){
//            System.out.println("触发batch写入 : " + objectCounter + "条数据");
//            t.interrupt();

//            uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            dst = "/hive/"+ uuid + ".txt";
//            WriteToHDFS.writeToHDFS(transactionArrayList, lock, hdfs, hiveConn, dst, dstPath, outputStream);
//            NotifyHiveToLoad.load(dst, hiveConn);
//            objectCounter = 0;
//            startMilli = System.currentTimeMillis();
//            transactionArrayList.clear();

    }


    @Override
    public void close() throws Exception {
        super.close();
        System.out.println("closeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        if (outputStream != null) {
//            outputStream.close();
//        }
        if (hiveConn != null) {
            hiveConn.close();
        }
        if (hdfs != null) {
            hdfs.close();
        }
    }

    public static void main(String[] args) {
//        hiveConn = GetConnection.getHiveConnection();
//        hdfs = GetConnection.getHDFSFileSystem();
//        Transaction transaction = Transaction.getRandomTransaction();
//        transaction.
    }
}