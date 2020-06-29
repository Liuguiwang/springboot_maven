package com.wzu.lgw.appinfosystem.dao;

import com.wzu.lgw.appinfosystem.pojo.DevUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DevUserMapper {

    DevUser devlogin(DevUser devUser);
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);



    DevUser selectuserById(int id);


    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}