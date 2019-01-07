package com.jk.car.service.impl;

import com.jk.car.mapper.BuyLoginMapper;
import com.jk.car.model.UserBean;
import com.jk.car.service.BuyLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
@Service("buyLoginService")
public class BuyLoginServiceImpl implements BuyLoginService {

    @Resource
    private BuyLoginMapper buyLoginMapper;

    @Override
    public UserBean queryPhoneById(String phone) {
        return buyLoginMapper.queryPhoneById(phone);
    }

    @Override
    public void addUserPhone(UserBean userBean1) {
        buyLoginMapper.addUserPhone(userBean1);
    }
}
