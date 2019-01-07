/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2018/12/28 14:49
 * Description: 测试实现类
 * History:
 */
package com.jk.car.service.impl;

import com.jk.car.mapper.TestMapper;
import com.jk.car.model.ParamsBean;
import com.jk.car.model.SellCarBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试实现类〉
 *
 * @author admin
 * @create 2018/12/28
 * @since 1.0.0
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    /**
     * 修改电话号码
     * @param id
     * @param phone_number
     */
    @Override
    public void updatePhone(Integer id, String phone_number) {
        UserBean userBean = new UserBean();
        userBean.setPhone(phone_number);
        userBean.setId(id);
        testMapper.updatePhone(id,phone_number);
    }

    /**
     * 添加
     * @param sellCarBean
     * @return
     */
    @Override
    public Integer  addSellCar(SellCarBean sellCarBean) {
        //新增参数表
        ParamsBean bean = new ParamsBean();
        bean.setName(sellCarBean.getMileage()+"万公里");
        bean.setCodetype("里程");
        bean.setCodeid(3);
        testMapper.addParamsTable(bean);
        //新增用户表
        String phoneNumber = sellCarBean.getPhoneNumber();
        //查询用户表里有没有该电话号码
        UserBean userByPhone=testMapper.queryUserByPhone(phoneNumber);
        Integer userid=null;
        if(userByPhone==null){
            UserBean userBean = new UserBean();
            userBean.setPhone(phoneNumber);
            userBean.setIfphoneconfirm(0);
            testMapper.addUserBean(userBean);
            userid=userBean.getId();
        }else{
            userid=userByPhone.getId();
        }
        //新增车辆表
        sellCarBean.setCarStatus(5);
        sellCarBean.setCarParameter(bean.getId());
        sellCarBean.setUserId(userid);
        testMapper. addSellCar(sellCarBean);
        return userid;
    }

    /**
     * 根据id查询电话号码
     * @param userId
     * @return
     */
    @Override
    public String queryUserPhone(Integer userId) {
        return testMapper.queryUserPhone(userId);
    }



}
