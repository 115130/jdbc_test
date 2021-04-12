package chinasofti.dao.impl;

import chinasofti.dao.AccountDao;
import chinasofti.entity.Account;
import chinasofti.util.BaseDao;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl extends BaseDao implements AccountDao {
    @Override
    public List<Account> queryAllAccount() {
        List<Account> accountList = new ArrayList<>();
        Account account = null;
        String sql = "select * from account;";
        Object[] params = {};
        rs = this.executeQuery(sql, params);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                account = new Account(id, name, balance);
                accountList.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //关闭资源
            this.closeResource(conn, pstmt, rs);
        }
        return accountList;
    }

    @Override
    public int add(Account account) {
        String sql="insert into account(name,balance) values(?,?);";
        Object[] params={account.getName(),account.getBalance()};
        result = super.executeUpdate(sql, params);
        return result;
    }

    @Override
    public int update(Account account) {
        String sql="update account set name=?,balance=? where id=?";
        return this.executeUpdate(sql, account.getName(),account.getBalance(),account.getId());
    }

    @Override
    public int delete(int id) {
        String sql="delete from account where id=?";

        return this.executeUpdate(sql, id);
    }

    @Test
    void m(){
        System.out.println(queryAccountByPage("曹", 1, 3));
    }

    @Override
    public List<Account> queryAccountByPage(String name,int i,int j) {
        List<Account> accountList = new ArrayList<>();
        Account account = null;
        String sql = "select * from account where  name like ? limit ?,?;";
        rs = this.executeQuery(sql, "%"+name+"%",i,j);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");
                double balance = rs.getDouble("balance");
                account = new Account(id, name, balance);
                accountList.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //关闭资源
            this.closeResource(conn, pstmt, rs);
        }
        return accountList;
    }
}
