package com.sdbi.mapper;

import com.sdbi.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户接口
 * @author chuan
 * @date 2020/2/11-23:26
 */
@Repository
public interface AccountMapper {
    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account (name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

    @Delete("delete from account where name=#{name}")
    public void delAccount(Account account);
}
