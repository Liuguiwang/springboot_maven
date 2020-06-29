package com.wzu.lgw.appinfosystem.service;

import com.wzu.lgw.appinfosystem.pojo.DataDictionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DataDictionaryService {
    /**
     * 根据typeCode查询相应的数据字典列表
     * @param typeCode
     * @return
     * @throws Exception
     */
    public List<DataDictionary> getDataDictionaryList(String typeCode)throws Exception;
}
