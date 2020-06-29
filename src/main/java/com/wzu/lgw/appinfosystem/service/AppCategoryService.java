package com.wzu.lgw.appinfosystem.service;

import com.wzu.lgw.appinfosystem.pojo.AppCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppCategoryService {
    /**
     * 根据父节点parentId获取相应的分类列表
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
