package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.exception.MyException;
import com.example.woc.mapper.AdminMapper;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    //获取总数
    public Integer select(){
        return adminMapper.select();
    }

    //删除
    public void delete(String username){
        Account account=userMapper.findByName(username);

        if(account == null){
            throw new MyException(-5,"用户不存在！删除失败！");
        }else{
            adminMapper.delete(username);
        }
    }

    //权限管理
    public Account update(String username,Integer role){
        adminMapper.update(username,role);
        return userMapper.findByName(username);
    }
}
