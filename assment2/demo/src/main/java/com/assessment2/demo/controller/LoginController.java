package com.assessment2.demo.controller;

import com.assessment2.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 跳转到登录页面
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    // 提交登录表单
    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        boolean ok = loginService.checkLogin(username, password);
        if (ok) {
            model.addAttribute("name", username);
            return "success";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "error";
        }
    }
}
