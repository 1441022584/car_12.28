package com.jk.car.mapper;

import com.jk.car.model.ParamsBean;
import com.jk.car.model.SellCarBean;
import com.jk.car.model.UserBean;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {

    /**
     * 添加参数表
     * @param bean
     */
    void addParamsTable(ParamsBean bean);

    /**
     * 添加汽车列表
     * @param sellCarBean
     */
    void addSellCar(SellCarBean sellCarBean);

    /**
     * 添加用户
     * @param userBean
     */
    void addUserBean(UserBean userBean);

    /**
     * 修改电话
     * @param id
     * @param phone_number
     */
    void updatePhone(@Param("id") Integer id, @Param("phone_number") String phone_number);

    /**
     * 根据id查询电话
     * @param userId
     * @return
     */
    String queryUserPhone(Integer userId);


    UserBean queryUserByPhone(@Param("phoneNumber") String phoneNumber);
}
