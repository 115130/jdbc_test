package chinasofti.dao;

import chinasofti.entity.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> queryAllAccount();//查询所有账户
    public int add(Account account);//新增账户
    public int update(Account account);//修改
    public int delete(int id);//删除
    public List<Account> queryAccountByPage(String name,int i,int j);//分页

}
