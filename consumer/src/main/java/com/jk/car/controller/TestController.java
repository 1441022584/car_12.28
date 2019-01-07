package com.jk.car.controller;

import com.jk.car.model.SellCarBean;
import com.jk.car.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 页面跳转
 */
@Controller
public class TestController {

    @Resource
    private TestService testService;

    /**
     * 跳转瓜子服务页面
     * @return
     */
    @RequestMapping("toServicePage")
    public String toServicePage(){
        return "CarService";
    }

    /**
     * 跳转我要卖车页面
     * @return
     */
    @RequestMapping("toSellCarPage")
    public String toSellCarPage(){
        return "SellCar";
    }
    /**
     * 免费卖车内容提交
     */
    @RequestMapping("addSellCar")
    @ResponseBody
    public Integer addSellCar(SellCarBean sellCarBean){
        return testService.addSellCar(sellCarBean);
    }

    /**
     * 电话号码确认
     * @param login_code
     * @param phone_number
     * @param request
     * @return
     */
    @RequestMapping("confirmPhone")
    @ResponseBody
    public boolean confirmPhone(String login_code, String phone_number, Integer userId, HttpServletRequest request){
        System.out.println("login_code"+login_code);
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if (code.equals(login_code)){
            String phone=testService.queryUserPhone(userId);
            if (!phone.equals(phone_number)){
                testService.updatePhone(userId,phone_number);
            }
            return true;
        }else{
            return false;
        }

    }
}
