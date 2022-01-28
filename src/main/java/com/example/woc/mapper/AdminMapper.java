package com.example.woc.mapper;

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
}
