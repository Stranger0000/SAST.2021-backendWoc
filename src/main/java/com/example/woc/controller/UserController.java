package com.example.woc.controller;

import com.example.woc.exception.MyException;
import com.example.woc.utils.Result;
import com.example.woc.entity.Account;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //这是一个示例,以POST方法提交数据
    @PostMapping("/simple")
    public void simple(String test) {
        //按住ctrl键来看看具体调用的这个函数吧
        userService.test(test);
    }

    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     * @param account
     */
    @PostMapping("/register")
    public Result uploadUsername(Account account) throws MyException{

        userService.insert(account);
        return new Result(true,null,null,account);

    }

    /**
     * 完成登录功能
     * @param
     * @return 是否登录成功
     */
    @PostMapping("/login")
    public Result login(String username,String password,HttpSession session) {

        Account user = userService.login(username, password);
        session.setAttribute("userLogin",user);
        if(user==null){
            throw new MyException(-4,"用户名或密码错误");
        }else {
            return new Result(true,null,null,user);
        }
    }
}


