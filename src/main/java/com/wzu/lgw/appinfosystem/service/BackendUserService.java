package com.wzu.lgw.appinfosystem.service;


import com.wzu.lgw.appinfosystem.pojo.BackendUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BackendUserService {
    BackendUser backlogin(BackendUser backendUser);
    List<BackendUser> selectAll(Integer currentPageNo, Integer pageSize);
    int count();
    BackendUser getuserById(int id);
    int addUser(BackendUser backendUser);
    int delUser(int id);
}
