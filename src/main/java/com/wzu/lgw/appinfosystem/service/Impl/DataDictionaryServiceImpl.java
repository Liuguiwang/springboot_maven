package com.wzu.lgw.appinfosystem.service.Impl;

import com.wzu.lgw.appinfosystem.dao.DataDictionaryMapper;
import com.wzu.lgw.appinfosystem.pojo.DataDictionary;
import com.wzu.lgw.appinfosystem.service.DataDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper mapper;

    @Override
    public List<DataDictionary> getDataDictionaryList(String typeCode)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.getDataDictionaryList(typeCode);
    }
}
