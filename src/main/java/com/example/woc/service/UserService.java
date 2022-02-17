package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.exception.MyException;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //示例
    public void test(String test) {
        userMapper.test(test);
    }

    //注册
    public void insert(Account account) {
        Account user = userMapper.findByName(account.getUsername());
        if (account.getUsername().equals("")) {
            throw new MyException(-1,"用户名不能为空！");
        } else if (account.getPassword().equals("")) {
            throw new MyException(-2,"密码不能为空！");
        } else if (user != null) {
            throw new MyException(-3,"用户已存在！");
        } else {
            userMapper.insert(account);
        }
    }

    //登录
    public Account login(String username,String password){
        return userMapper.login(username,password);
    }

}
