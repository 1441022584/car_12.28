package com.jk.car.mapper;

import com.jk.car.model.CarBean;
import com.jk.car.model.UserBean;

import java.util.HashMap;
import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/2 13:10
 * @pescription:
 */
public interface HomeMapper {
    /**
     * Description: 根据当前汽车id查询该商品说的所有信息 点击进去该商品的详情
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  20:13
     */
    CarBean queryCarInfoByCarId(Integer carId);

    /**
     * Description:查询首页车型展示
     *
     * @param:  * @param carBean
     * @return:
     * @auther: cym
     * @date:  19:32
     */
    List<CarBean> queryCarHome(CarBean carBean);

    /**
     * Description:保存预约卖车信息
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  23:18
     */
    void saveMakeCar(CarBean carBean);
    /**
     * Description: 新增用户手机号  注册
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  15:43
     */
    void addUserPhone(String phoneNumber);

    /**
     * Description:查询当前手机号是否存在用户表
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  15:46
     */
    UserBean queryUserPhoneByphone(String phoneNumber);
/**
     * Description: 保存预约卖车用户手机号
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  16:32
     */
    void addMakerUserPhone(UserBean userBean);
}
