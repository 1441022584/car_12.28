package com.jk.car.mapper;

import com.jk.car.model.UserBean;

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
public interface BuyLoginMapper {


    UserBean queryPhoneById(String phone);

    void addUserPhone(UserBean userBean1);
}
