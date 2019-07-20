package top.cocobolo;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther lz
 * @create 2019-07-19 15:28
 */
public class WriteToHDFS {
    public static void writeToHDFS(ArrayList<Transaction> list, FileSystem hdfs, Connection hiveConn, String dst, Path dstPath, FSDataOutputStream outputStream) throws IOException {
        dstPath = new Path(dst);
        outputStream = hdfs.create(dstPath,true);
        byte[] bytes = turnArrayListToBytes(list);
        outputStream.write(bytes);
        System.out.println(dst+"写入HDFS成功");
        outputStream.close();
    }

    public static byte[] turnArrayListToBytes(ArrayList<Transaction> list){
        StringBuilder sb = new StringBuilder();
        String rowDelimiter = "\001";
        int rowDelimiterLength = 4;
        String lineDelimiter = "\n";
        int lineDilimiterLength = 2;
        for(Transaction transaction : list){
            String s1 = transaction.getTransaction_id().toString();
            String s2 = transaction.getCard_number().toString();
            String s3 = transaction.getTerminal_id().toString();
            String s4 = transaction.getTransaction_time().toString();
            String s5 = transaction.getTransaction_type().toString();
            String s6 = String.format("%.2f",transaction.getAmount());
            sb.append(s1).append(rowDelimiter);
            sb.append(s2).append(rowDelimiter);
            sb.append(s3).append(rowDelimiter);
            sb.append(s4).append(rowDelimiter);
            sb.append(s5).append(rowDelimiter);
            sb.append(s6).append(lineDelimiter);
        }
        sb.deleteCharAt(sb.length() - 1);//去掉最后一个换行符
        byte[] res =  sb.toString().getBytes();
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Transaction> al = new ArrayList<Transaction>();
        for (int i = 0; i < 3; i++) {
            al.add(Transaction.getRandomTransaction());
        }
        StringBuilder sb = new StringBuilder();
        String rowDelimiter = "\001";
        String lineDelimiter = "\n";
        for(Transaction transaction : al){
            String s1 = transaction.getTransaction_id().toString();
            String s2 = transaction.getCard_number().toString();
            String s3 = transaction.getTerminal_id().toString();
            String s4 = transaction.getTransaction_time().toString();
            String s5 = transaction.getTransaction_type().toString();
            String s6 = String.format("%.2f",transaction.getAmount());
            sb.append(s1).append(rowDelimiter);
            sb.append(s2).append(rowDelimiter);
            sb.append(s3).append(rowDelimiter);
            sb.append(s4).append(rowDelimiter);
            sb.append(s5).append(rowDelimiter);
            sb.append(s6).append(lineDelimiter);
        }
        sb.deleteCharAt(sb.length() - 1);//去掉最后一个换行符
        System.out.println("sb = " + sb);
        byte[] res =  sb.toString().getBytes();
        System.out.println("res = " + res);
    }
}
