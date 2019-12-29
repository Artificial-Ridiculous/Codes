package top.cocobolo;

import java.sql.*;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import java.sql.PreparedStatement;

/**
 * 选择PreparedStatement对象与否，在于相同句法的SQL语句是否执行了多次，
 * 而且两次之间的差别仅仅是变量的不同。
 * 如果仅仅执行了一次的话，它应该和普通的Statement对象毫无差异，体现不出它预编译的优越性。
 */

public class HiveSink extends RichSinkFunction<Transaction> {
    private PreparedStatement state ;
    private Connection conn ;
    private String querySQL = "";
//    private String sql;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        conn = GetConnection.getHiveConnection();
        querySQL = "insert into transaction(transaction_id,card_number,terminal_id,transaction_time,transaction_type,amount) values(? ,?, ?, ?, ?, ?)";

    }

    @Override
    public void close() throws Exception {
        super.close();
        if (state != null) {
            state.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public void invoke(Transaction value, Context context) throws Exception {


        state.setLong(1,value.getTransaction_id());
        state.setLong(2,value.getCard_number());
        state.setLong(3,value.getTerminal_id());
        state.setString(4,value.getTransaction_time().toString());
        state.setInt(5,value.getTransaction_type());
        state.setDouble(6,value.getAmount());

        state.executeUpdate()   ;  // 用于update delete insert;返回受影响的行数(更新计数) int
        //state.executeQuery 用于select;返回结果集ResultSet
        //state.execute  用于未知的返回结果更复杂的情况
    }




    public static void main(String[] args) {
        GetConnection.getHiveConnection();
    }
}

