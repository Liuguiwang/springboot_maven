package com.wzu.lgw.appinfosystem.dao;

import com.wzu.lgw.appinfosystem.pojo.AppVersion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AppVersionMapper {


    public List<AppVersion> getAppVersionList(@Param("appId") Integer appId) throws Exception;

    public int add(AppVersion appVersion)throws Exception;

    public int getVersionCountByAppId(@Param("appId") Integer appId)throws Exception;

    public int deleteVersionByAppId(@Param("appId") Integer appId)throws Exception;

    public AppVersion getAppVersionById(@Param("id") Integer id)throws Exception;

    public int modify(AppVersion appVersion)throws Exception;

    public int deleteApkFile(@Param("id") Integer id)throws Exception;

}