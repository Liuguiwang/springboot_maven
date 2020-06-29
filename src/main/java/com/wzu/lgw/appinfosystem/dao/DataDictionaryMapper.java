package com.wzu.lgw.appinfosystem.dao;

import com.wzu.lgw.appinfosystem.pojo.DataDictionary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DataDictionaryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode)throws Exception;

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}