package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.exception.MyException;
import com.example.woc.utils.Result;
import com.example.woc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 04:19
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    //请仿照 User 补充 Admin 的三层架构并完成接口
    @Autowired
    private AdminService adminService;

    /**
     * 获取当前的账户总数
     * @return
     */
    @GetMapping("/getAmount")
    public Result getAmountOfAccounts(){

        return new Result(true,null,null,adminService.select());
    }

    /**
     * 根据用户名删除账户
     * @param username
     */
    @DeleteMapping("/delete")
    public Result deleteAccount(String username){

        adminService.delete(username);
        return new Result(true, null, null, null);

    }

    /**
     * 超级管理员：根据用户名管理role
     * @param username
     * @return
     */
    @PutMapping("/update")
    public Result updateAccount(String username, Integer role){
        Account account= adminService.update(username,role);
        if(account == null){
            throw new MyException(-6,"用户不存在！无法更改权限！");
        } else {
            return new Result(true,null,null,account);
        }


    }
}
