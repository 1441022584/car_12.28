package com.jk.car.service;

import com.jk.car.model.CarBean;
import com.jk.car.model.UserBean;

import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/2 12:00
 * @pescription:
 */
public interface HomeService {
    /**
         * Description: 查询首页所有车辆
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  23:21
         */
    List<CarBean> queryCarHome(String carType, Integer carBrand);
    /**
     * Description: 根据汽车id查询出该商品的所有详细信息
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  23:21
     */
    CarBean queryCarInfoByCarId(Integer carId);

    /**
     * Description: 保存预约卖车信息
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  23:21
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
     * Description: 查询当前手机号是否存在用户表
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  15:44
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
