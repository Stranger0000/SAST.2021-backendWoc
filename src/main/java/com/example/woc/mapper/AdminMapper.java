package com.example.woc.mapper;

import com.example.woc.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    //获取总数
    Integer select();

    //删除
    void delete(@Param("username") String username);

    //更改权限
    void update(@Param("username") String username,@Param("role") Integer role);
}
