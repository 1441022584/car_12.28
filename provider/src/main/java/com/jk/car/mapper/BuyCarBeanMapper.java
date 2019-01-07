package com.jk.car.mapper;

import com.jk.car.model.BuyCarBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BuyCarBeanMapper {

    /**
     * 查询买车列表
     * @return
     */
    List<BuyCarBean> getBuyCarList(HashMap<Object, Object> map);
    /**
     * 查询数据库的数据总条数
     * @return
     */
    Long queryCountList();

    /**
     * 分页查询
     * @return
     */
    List<BuyCarBean> findUserList(Map map);

    /**
     * 新增数据
     * @return
     */
    void insertMany(List<BuyCarBean> list);

    /**
     * 查询买车列表根据Id
     * @return
     */
    BuyCarBean getBuyCarListOne(Integer id);

    /**
     * 查询列表总条数
     * @return
     */
    int getBuyCarListCount();

    /**
     * 买车首页Highchars根据年
     * @return
     */
    List<Map<String, Object>> getBuyCarHighcharsYear();

    /**
     * 回显地址和id字段
     */
    BuyCarBean getBuyCarListById(BuyCarBean buyCarBean);

    /**
     * 预约看车提交给管理员审批
     */
    void addBuyCarStatus(BuyCarBean buyCarBean);
}