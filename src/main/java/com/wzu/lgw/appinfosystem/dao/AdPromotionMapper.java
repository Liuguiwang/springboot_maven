package com.wzu.lgw.appinfosystem.dao;

import com.wzu.lgw.appinfosystem.pojo.AdPromotion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AdPromotionMapper {


    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);



    AdPromotion selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}