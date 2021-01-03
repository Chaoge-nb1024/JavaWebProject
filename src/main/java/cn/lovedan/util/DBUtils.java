package cn.lovedan.util;

import org.apache.commons.beanutils.BeanUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * jdbc工具类
 * @author dan's lover
 * @version 1.0
 */
public class DBUtils {
    /**
     * 获取数据库连接对象
     * @return 数据库连接对象
     * @throws Exception 异常信息
     */
    public static Connection getConnection () throws Exception{
        // 使用配置文件来获取数据
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);
        // 读取数据
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        // 注册驱动
        Class.forName(driver);
        // 返回数据库连接对象
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 保存数据至数据库中
     * @param sql SQL语句
     * @param args SQL语句限定条件
     * @return 返回true，保存成功；返回false，保存失败
     */
    public static boolean save(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;
        try {
            // 获取数据库连接对象
            conn = getConnection();
            // SQL语句预编译
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1, args[i]);
                }
            }
            // 返回更新的记录数
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count != null && count > 0 ? true : false;
    }

    /**
     * 返回查询结果的记录数
     * @param sql SQL语句
     * @param args SQL语句中限定条件
     * @return 记录数
     */
    public static Integer getCount(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0){
                for (int i = 0; i < args.length; i++){
                    ps.setObject(i+1, args[i]);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return count;
    }

    /**
     * 查询返回一个指定对象
     * @param clazz 对象类型
     * @param sql SQL语句
     * @param args SQL语句限定条件
     * @param <T> 泛型参数
     * @return T 类型对象
     */
    public static <T> T getSingleObject(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T instance = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1, args[i]);
                }
            }
            rs = ps.executeQuery();
            // 获得结果集元数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 获得当前结果集的列数
            int columnNum = metaData.getColumnCount();
            // 处理结果集
            while (rs.next()) {
                // key 存放列名，value存放列值
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= columnNum; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName    );
                    rowMap.put(columnName, columnValue);
                }
                instance = clazz.newInstance();
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    // 使用 apache.commons.beanutils 包下的工具类进行对象赋值操作
                    BeanUtils.setProperty(instance, propertyName, propertyValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return instance;
    }

    /**
     * 保存用户，并返回用户编号
     * @param sql SQL语句
     * @param args SQL语句中限定条件
     * @param <T> 泛型参数
     * @return 用户编号
     */
    public static <T> Integer updateForPrimary(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer primaryKey = null;
        try{
            // 获取数据库连接对象
            connection = getConnection();
            // SQL 语句预编译, 加上参数 【Statement.RETURN_GENERATED_KEYS】可将主键查询出来
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 判断是否对SQL语句中的占位符进行操作
            if (args != null && args.length > 0){
                for (int i = 0; i < args.length; i++){
                    // 判断当前类型，如果是 java.util.Date 类型，转换为 java.sql.Date
                    if (args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date) args[i];
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i+1, args[i]);
                }
            }
            // 更新数据
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                primaryKey = rs.getInt(1);
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            close(connection, ps, rs);
        }
        return primaryKey;
    }

    /**
     * 用于 SQL 查询，返回查询结果，以集合形式显示
     * @param clazz 待查询数据的数据类型
     * @param sql SQL语句
     * @param args SQL语句限定条件
     * @param <T> 泛型参数
     * @return 数据类型为 clazz 型的集合
     */
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            // 获取数据库连接对象
            connection = DBUtils.getConnection();
            // SQL语句预编译
            ps = connection.prepareStatement(sql);
            // 判断是否对SQL语句中的占位符进行操作
            if (args != null && args.length > 0){
                for (int i = 0; i < args.length; i++){
                    ps.setObject(i+1, args[i]);
                }
            }
            // 获取结果集
            rs = ps.executeQuery();
            // 获取结果集元数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 获取当前结果集的列数
            int colNum = metaData.getColumnCount();
            // 处理结果集
            list = new ArrayList<>();
            while(rs.next()){
                // key 存放列名，value 存放列值。
                // for 循环完成之后，rowMap 中存放了一条记录
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= colNum; i++){
                    String columnName = metaData.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    if (columnValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                // 创建一个实例对象
                T bean = clazz.newInstance();
                for (Map.Entry<String, Object> entry : rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    // 使用 apache.commons.beanutils 包下的工具类进行对象赋值操作
                    BeanUtils.setProperty(bean, propertyName, propertyValue);
                }
                list.add(bean);
            }
            int a = 0;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection, ps, rs);
        }
        return list;
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
