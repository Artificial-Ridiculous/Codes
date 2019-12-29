/**
 * @auther lz
 * @create 2019-07-16 15:51
 */

package top.cocobolo;

//import com.alibaba.fastjson.JSON;
//import org.apache.flink.configuration.Configuration;
//import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
//import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.*;
import java.util.Random;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import top.cocobolo.Transaction;


public class ExecuteUpdate {
//    private Connection conn ;
//    private PreparedStatement state ;


//    @Override
//    public void open(Configuration parameters) throws Exception {
//        super.open(parameters);
//        conn = getConnection();
//        //System.out.println("conn=" + conn);
//        String sql = "insert into transactions(transactionID,cardNumber,terminalID,transactionDate,transactionTime,transactionType,amount) values(?, ?, ?, ?, ?, ?, ?);";
//        state = this.conn.prepareStatement(sql);
//        //System.out.println("state=" + state);
//    }

//    @Override
//    public void close() throws Exception {
//        super.close();
//        if (conn != null) {
//            conn.close();
//        }
//        if (state != null) {
//            state.close();
//        }
//    }
//
//    @Override
//    public void invoke(Transaction value, Context context) throws Exception {
//        state.setLong(1,value.getTransactionID());
//        state.setLong(2,value.getCardNumber());
//        state.setLong(3,value.getTerminalID());
//        state.setDate(4,value.getTransactionDate());
//        state.setTime(5,value.getTransactionTime());
//        state.setInt(6,value.getTransactionType());
//        state.setDouble(7,value.getAmount());
//        state.executeUpdate();
//    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            String jdbc = "com.mysql.jdbc.Driver";
            Class.forName(jdbc);
            String url = "jdbc:mysql://aliyun.cocobolo.top:3306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url +
                            "?useUnicode=true" +
                            "&useSSL=false" +
                            "&characterEncoding=UTF-8" +
                            "&serverTimeZone=UTC" +
                            "rewriteBatchedStatements=true" ,
                    user,
                    password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT into transaction values (?, ?, ?, ?, ?, ?, ?)");

        for (int n = 0; n < 100; n++) {
            int rand8 = (int)(1+Math.random()*(100000000-1+1));
            int rand7 = (int)(1+Math.random()*(100000000-1+1));
            int rand6 = (int)(1+Math.random()*(100000000-1+1));
            Date currentDate = new Date(System.currentTimeMillis());
            System.out.println("currentDate = "+ currentDate);
            Time currentTime = new Time(System.currentTimeMillis());
            System.out.println("currentTime = "+ currentTime);
            int rand1 = (int)(1+Math.random()*(4-1+1));
            float generatorFloat = new Random().nextFloat()*1000;

            Transaction transaction = new Transaction(rand8,rand7,rand6,currentDate,currentTime,rand1,generatorFloat);

            System.out.println("transaction = " + transaction);

            ps.setLong(1,transaction.getTransactionID());
            ps.setLong(2,transaction.getCardNumber());
            ps.setLong(3,transaction.getTerminalID());
            ps.setDate(4,transaction.getTransactionDate());
            ps.setTime(5,transaction.getTransactionTime());
            ps.setInt(6,transaction.getTransactionType());
            ps.setFloat(7,transaction.getAmount());
            ps.addBatch();

            Thread.sleep(100);

        }
        ps.executeBatch();
    }

}