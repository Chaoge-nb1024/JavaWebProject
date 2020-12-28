package cn.lovedan.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc工具类
 * @author dan's lover
 * @version 1.0
 */
public class DBUtils {
    /**
     * 借用阿里云连接池，获取数据库连接对象
     * @return 数据库连接对象
     * @throws Exception 异常信息
     */
    public static Connection getConnection () throws Exception{
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/main/webapp/WEB-INF/classes/db.properties");
        Properties properties = new Properties();
        properties.load(in);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    /**
     * 关闭资源
     * @param conn 数据库连接对象
     * @param ps 原始语句对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
