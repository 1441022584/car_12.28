/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2018/12/28 14:48
 * Description: 测试接口
 * History:
 */
package com.jk.car.service;

import com.jk.car.model.ParamsBean;
import com.jk.car.model.SellCarBean;
import com.jk.car.model.UserBean;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试接口〉
 *
 * @author admin
 * @create 2018/12/28
 * @since 1.0.0
 */
public interface TestService {

    /**
     * 确认电话修改用户电话号码
     * @param id
     * @param phone_number
     */
    void updatePhone(Integer id, String phone_number);

    /**
     * 添加预约卖车车辆信息
     * @param sellCarBean
     * @return
     */
    Integer addSellCar(SellCarBean sellCarBean);

    /**
     * 根据用户id查询用户电话
     * @param userId
     * @return
     */
    String queryUserPhone(Integer userId);
}
