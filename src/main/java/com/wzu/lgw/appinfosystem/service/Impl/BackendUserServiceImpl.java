package com.wzu.lgw.appinfosystem.service.Impl;

import com.wzu.lgw.appinfosystem.dao.BackendUserMapper;
import com.wzu.lgw.appinfosystem.pojo.BackendUser;
import com.wzu.lgw.appinfosystem.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    BackendUserMapper backendUserMapper;
    @Override
    public BackendUser backlogin(BackendUser backendUser) {
        return backendUserMapper.backendlogin(backendUser);
    }

    @Override
    public List<BackendUser> selectAll(Integer currentPageNo, Integer pageSize) {
        return backendUserMapper.selectAll(currentPageNo,pageSize);
    }

    @Override
    public int count() {
        return backendUserMapper.count();
    }

    @Override
    public BackendUser getuserById(int id) {
        return backendUserMapper.getUserinfoById(id);
    }

    @Override
    public int addUser(BackendUser backendUser) {

        if(backendUserMapper.insert(backendUser)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int delUser(int id) {
       if(backendUserMapper.deleteById(id)>0){
           return 1;
       }
       return 0;
    }
}
