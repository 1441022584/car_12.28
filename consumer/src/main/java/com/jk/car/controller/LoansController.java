/**
 * 金融管理类
 *
 */
package com.jk.car.controller;

import com.jk.car.model.BorrowerBean;
import com.jk.car.service.LoansService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoansController {

    @Resource
    private LoansService loansService;

    /**
     * 跳转到金融页面
     * @return
     */
    @RequestMapping("toLoans")
    private String toLoans(){
        return "financeMain";
    }

    /**
     * 新增贷款人 详细信息
     * @param borrower
     * @return
     */
    @RequestMapping("saveBorrwer")
    @ResponseBody
    public Boolean saveBorrwer(BorrowerBean borrower){
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        System.out.println(current);// new Date()为获取当前系统时
        borrower.setApplyTime(current);
        loansService.saveBorrwer(borrower);
        //System.out.println(borrower);
     return true;
    }



}
