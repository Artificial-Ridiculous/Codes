/**
 * @auther lz
 * @create 2019-07-16 15:51
 */

package top.cocobolo;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ExecuteUpdate extends RichSinkFunction<Transaction>{
    private PreparedStatement state ;
    private Connection conn ;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        conn = getConnection();
        //System.out.println("conn=" + conn);
        String sql = "insert into transactions(transactionID,cardNumber,terminalID,transactionDate,transactionTime,transactionType,amount) values(?, ?, ?, ?, ?, ?, ?);";
        state = this.conn.prepareStatement(sql);
        //System.out.println("state=" + state);
    }

    @Override
    public void close() throws Exception {
        super.close();
        if (conn != null) {
            conn.close();
        }
        if (state != null) {
            state.close();
        }
    }

    @Override
    public void invoke(Transaction value, Context context) throws Exception {
        state.setLong(1,value.getTransactionID());
        state.setLong(2,value.getCardNumber());
        state.setLong(3,value.getTerminalID());
        state.setDate(4,value.getTransactionDate());
        state.setTime(5,value.getTransactionTime());
        state.setInt(6,value.getTransactionType());
        state.setDouble(7,value.getAmount());
        state.executeUpdate();
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            String jdbc = "com.mysql.jdbc.Driver";
            Class.forName(jdbc);
            String url = "jdbc:mysql://router.cocobolo.top:33306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url +
                            "?useUnicode=true" +
                            "&useSSL=false" +
                            "&characterEncoding=UTF-8" +
                            "&serverTimezone=UTC",
                    user,
                    password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}