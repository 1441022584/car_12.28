package com.jk.car.controller;

import com.jk.car.model.UserBean;
import com.jk.car.service.BuyLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 方法实现说明
 *
 * @author 王垚
 * <p>
 * $
 * @return $
 * @exception
 * @date $ $
 */
@Controller
public class BuyLoginController {

    @Resource
    private BuyLoginService buyLoginService;

    @RequestMapping("buylogin")
    @ResponseBody
    public HashMap<String,Object> buylogin(String login_code, UserBean userBean, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String codes = (String) session.getAttribute("code");
        System.out.println(codes);
        //根据前台传过来的手机号码查询数据库是否有该账号
        UserBean userInfo= buyLoginService.queryPhoneById(userBean.getPhone());
        System.out.println(userInfo);
        String phone = userBean.getPhone();
            if ( userInfo==null || "".equals(userInfo)){
                //如果没有者新增一条数据
                UserBean userBean1 = new UserBean();
                userBean1.setIfphoneconfirm(1);
                userBean1.setPassword("111");
                userBean1.setPhone(userBean.getPhone());
                userBean1.setUsername(userBean.getPhone());
                buyLoginService.addUserPhone(userBean1);
            }
             //根据前台传过来的手机号码查询数据库是否有该账号
             UserBean userInfo1= buyLoginService.queryPhoneById(userBean.getPhone());
            if (userInfo1==null || "".equals(userInfo1)){
                map.put("code",1);
                map.put("msg","手机号输入错误");
                return map;

            }
            if (!codes.equals(login_code)){
                map.put("code",2);
                map.put("msg","验证码输入错误");
                return map;
            }
            session.setAttribute(session.getId(),userInfo);
            map.put("code",0);
            map.put("msg","用户登陆成功");
             UserBean userId = (UserBean) session.getAttribute(session.getId());
             System.out.println(userId);
            return map;


    }
}
