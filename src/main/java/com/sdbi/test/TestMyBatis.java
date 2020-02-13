package com.sdbi.test;

import com.sdbi.mapper.AccountMapper;
import com.sdbi.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author chuan
 * @date 2020/2/12-21:46
 */
public class TestMyBatis {
    //测试查询
    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        //查询所有数据
        List<Account> list = mapper.findAll();
        for (Account account:list){
            System.out.println(account);
        }
        //关闭资源
        session.close();
        is.close();
    }
    //测试保存
    @Test
    public void run2() throws Exception {
        Account account=new Account();
        account.setName("翠翠");
        account.setId(3);
        account.setMoney(400.0);
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        //保存
        mapper.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        is.close();
    }
}
