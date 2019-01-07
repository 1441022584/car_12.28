package com.jk.car.service.impl;

import com.jk.car.mapper.HomeMapper;
import com.jk.car.model.CarBean;
import com.jk.car.model.UserBean;
import com.jk.car.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 褚仪明
 * @date: 2019/1/2 13:09
 * @pescription:
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    /**
     * Description: 查询所有车型  首页展示
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  19:49
     */
    @Override
    public List<CarBean> queryCarHome(String carType,Integer carBrand) {
        CarBean carBean = new CarBean();
        carBean.setCarType(carType);
        carBean.setCarBrand(carBrand);
        return homeMapper.queryCarHome(carBean);
    }

    /**
         * Description: 根据汽车id查询出该商品的所有详细信息
         *
         * @param:  * @param null
         * @return:
         * @auther: cym
         * @date:  9:01
         */
    @Override
    public CarBean queryCarInfoByCarId(Integer carId) {
        return homeMapper.queryCarInfoByCarId(carId);
    }

    /**
         * Description: 保存预约卖车信息
         *
         * @param:  * @param null
         * @return: 
         * @auther: cym
         * @date:  23:22
         */
    @Override
    public void saveMakeCar(CarBean carBean) {
        //获取到前台手机号
        String userPhone = carBean.getUserPhone();
        System.out.println(userPhone);
        //根据前台传过来手机号查询数据库是否有该手机号
        UserBean userbean = homeMapper.queryUserPhoneByphone(userPhone);

        Integer userId = null;
        //如果没有该手机号  就将用户手机号增进去
        if(userbean == null){
            UserBean userBean = new UserBean();
            userBean.setPhone(userPhone);
            userBean.setUsername(userPhone);
            homeMapper.addMakerUserPhone(userBean);
            userId=userBean.getId();
        }else {
            userId=userbean.getId();
        }

        carBean.setUserId(userId);
        homeMapper.saveMakeCar(carBean);
    }
/**
     * Description: 新增用户手机号  注册
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  15:46
     */
    @Override
    public void addUserPhone(String phoneNumber) {
        homeMapper.addUserPhone(phoneNumber);
    }
/**
     * Description:查询当前手机号是否存在用户表
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  15:46
     */
    @Override
    public UserBean queryUserPhoneByphone(String phoneNumber) {
        return homeMapper.queryUserPhoneByphone(phoneNumber);
    }
/**
     * Description: 保存预约卖车用户手机号
     *
     * @param:  * @param null
     * @return:
     * @auther: cym
     * @date:  16:32
     */
    @Override
    public void addMakerUserPhone(UserBean userBean) {
        
        homeMapper.addMakerUserPhone(userBean);
    }



}
