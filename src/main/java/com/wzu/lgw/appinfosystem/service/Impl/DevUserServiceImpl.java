package com.wzu.lgw.appinfosystem.service.Impl;

import com.wzu.lgw.appinfosystem.dao.DevUserMapper;
import com.wzu.lgw.appinfosystem.pojo.DevUser;
import com.wzu.lgw.appinfosystem.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    DevUserMapper devUserMapper;
    @Override
    public DevUser devlogin(DevUser devUser) {
        return devUserMapper.devlogin(devUser);
    }

    @Override
    public DevUser getUserById(int id) {
        return devUserMapper.selectuserById(id);
    }


}
