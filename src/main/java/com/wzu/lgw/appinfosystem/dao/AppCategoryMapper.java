package com.wzu.lgw.appinfosystem.dao;

import com.wzu.lgw.appinfosystem.pojo.AppCategory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AppCategoryMapper {


    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);
    public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId)throws Exception;

    AppCategory selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}