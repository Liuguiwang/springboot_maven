package com.wzu.lgw.appinfosystem.service;

import com.wzu.lgw.appinfosystem.pojo.DevUser;
import org.springframework.stereotype.Component;

@Component
public interface DevUserService {
    DevUser devlogin(DevUser devUser);

    DevUser getUserById(int id);
}
