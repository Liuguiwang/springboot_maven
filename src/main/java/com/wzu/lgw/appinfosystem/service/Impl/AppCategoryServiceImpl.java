package com.wzu.lgw.appinfosystem.service.Impl;

import com.wzu.lgw.appinfosystem.dao.AppCategoryMapper;
import com.wzu.lgw.appinfosystem.pojo.AppCategory;
import com.wzu.lgw.appinfosystem.service.AppCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryMapper mapper;

    @Override
    public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.getAppCategoryListByParentId(parentId);
    }
}
