package com.example.woc.service;

import com.example.woc.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //获取总数
    public Integer select(Integer count){
        return adminMapper.select(count);
    }

    //删除
    public void delete(String username){
        adminMapper.delete(username);
    }
}
