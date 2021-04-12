package chinasofti.service.impl;

import chinasofti.dao.AccountDao;
import chinasofti.entity.Account;
import chinasofti.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;


    public AccountDao getAccountDao() {
        return accountDao;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public List<Account> queryAllAccount() {
        return accountDao.queryAllAccount();
    }

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public List<Account> queryAccountByPage(String name,int i, int j) {
        return accountDao.queryAccountByPage(name,i,j);
    }
}
