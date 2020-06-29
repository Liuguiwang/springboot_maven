package com.wzu.lgw.appinfosystem.dao;
import com.wzu.lgw.appinfosystem.pojo.BackendUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BackendUserMapper {

    BackendUser backendlogin(BackendUser backendUser);
    int deleteById(int id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectAll(@Param(value = "from") Integer currentPageNo,
                                @Param(value = "pageSize") Integer pageSize);

    int count();

    BackendUser getUserinfoById(int id);


    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}