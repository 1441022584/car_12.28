package com.jk.car.service;

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
public interface BuyLoginService {

    /**
     * 查询手机号码码是否存在
     * @param phone
     * @return
     */
    UserBean queryPhoneById(String phone);
    
    /**
     * 如果没有者新增一条数据
     * */
    void addUserPhone(UserBean userBean1);
}
