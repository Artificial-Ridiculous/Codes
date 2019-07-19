package top.cocobolo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @auther lz
 * @create 2019-07-19 16:37
 */
public class NotifyHiveToLoad {
    public static void load(String dst, Connection hiveConn) throws SQLException {
        Statement stmt = hiveConn.createStatement();
        String sql = " load data inpath '"+dst+"' into table transaction ";
        stmt.execute(sql);
        System.out.println("loadData到Hive表成功！");
    }
}
