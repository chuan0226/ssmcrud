package com.sdbi.service.impl;

import com.sdbi.mapper.AccountMapper;
import com.sdbi.pojo.Account;
import com.sdbi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chuan
 * @date 2020/2/11-23:30
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户。。。");
        return accountMapper.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountMapper.saveAccount(account);
    }

    @Override
    public void delAccount(Account account) {
        accountMapper.delAccount(account);
    }
}
