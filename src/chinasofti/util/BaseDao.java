package chinasofti.util;


import java.sql.*;

public class BaseDao {
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;
    protected int result = 0;

    //1 是否连接对象
    public boolean getConn() {
        boolean flag = false;
        try {
            //1 加载驱动
            Class.forName(Constrant.driver);
            //2获取连接对象
            conn = DriverManager.getConnection(Constrant.url, Constrant.name, Constrant.pwd);
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //2 查询方法query select * from emp where empno=120
    public ResultSet executeQuery(String sql, Object... params) {
        if (getConn()) {//连接成功
            try {
                pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
                rs = pstmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    //3 增删改update
    public int executeUpdate(String sql, Object... params) {
        if (getConn()) {
            try {
                //得到pstmt对象
                pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    //
                    pstmt.setObject(i + 1, params[i]);
                }
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    //4 关闭资源，释放连接

    public void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
