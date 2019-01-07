/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/1 17:32
 * Description: 控制层
 * History:
 */
package com.jk.car.controller;

import com.jk.car.model.TreeBean;
import com.jk.car.service.UserService;
import com.jk.car.utils.PageResult;
import com.jk.car.utils.RandomCode;
import com.jk.car.utils.SendMessageUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈控制层〉
 *
 * @author admin
 * @create 2019/1/1
 * @since 1.0.0
 */
@Controller
public class UserController {


    @Resource
    private UserService userService;

    /**
     * 获取验证码
     * @param phone_number
     * @param request
     */
    @RequestMapping("getCode")
    @ResponseBody
    public void getCode(String phone_number, HttpServletRequest request){
        System.out.println(phone_number);
        RandomCode randomCode = new RandomCode();
        String randomCode1 = randomCode.getRandomCode(6);
        System.out.println(randomCode1);
        Integer send = SendMessageUtil.send("lixiaowei", "d41d8cd98f00b204e980", phone_number, "验证码:" + randomCode1);
        SendMessageUtil.getMessage(send);
         request.getSession().setAttribute("code", randomCode1);
    }

    /**
     * 登陆
     * @param login_code
     * @param request
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public boolean login(String login_code,String phone_number ,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user",phone_number);
        String code = (String) session.getAttribute("code");
        System.out.println(code);
        if (code.equals(login_code)){
            return true;
        }else{
            return false;
        }
    }

}
