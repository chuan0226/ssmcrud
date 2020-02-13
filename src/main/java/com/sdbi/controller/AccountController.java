package com.sdbi.controller;

import com.sdbi.pojo.Account;
import com.sdbi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author chuan
 * @date 2020/2/12-0:21
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户信息。。。");
        //这里能调用service方法就成功了
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse resp, HttpServletRequest req) throws Exception {
        accountService.saveAccount(account);
        resp.sendRedirect(req.getContextPath()+"/account/findAll");
        return ;
    }
    @RequestMapping("/del")
    public void del(Account account, HttpServletResponse resp, HttpServletRequest req) throws Exception {
        accountService.delAccount(account);
        resp.sendRedirect(req.getContextPath()+"/account/findAll");
        return ;
    }
}
