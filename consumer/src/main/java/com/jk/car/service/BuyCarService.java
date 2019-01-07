package com.jk.car.service;

import com.jk.car.model.BuyCarBean;

import java.util.List;
import java.util.Map;

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
public interface BuyCarService {

    /**
     * 查询买车列表
     * @return
     */
    List<BuyCarBean> getBuyCarList(BuyCarBean buyCarBean);

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
