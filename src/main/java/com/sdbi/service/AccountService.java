package com.sdbi.service;

import com.sdbi.pojo.Account;

import java.util.List;

/**
 * @author chuan
 * @date 2020/2/11-23:29
 */
public interface AccountService {
    //查询所有账户
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);

    //删除账户信息
    public void delAccount(Account account);
}
