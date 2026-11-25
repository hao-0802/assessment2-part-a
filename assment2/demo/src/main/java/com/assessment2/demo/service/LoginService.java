package com.assessment2.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // 模拟账号密码
    public boolean checkLogin(String username, String password) {
        return "lin".equals(username) && "123".equals(password);
    }
}
