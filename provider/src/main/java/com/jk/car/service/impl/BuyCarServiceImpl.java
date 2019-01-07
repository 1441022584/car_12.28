package com.jk.car.service.impl;

import org.springframework.stereotype.Service;
import com.jk.car.mapper.BuyCarBeanMapper;
import com.jk.car.model.BuyCarBean;
import com.jk.car.service.BuyCarService;

import javax.annotation.Resource;
import java.util.HashMap;
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
@Service("buyCarService")
public class BuyCarServiceImpl implements BuyCarService {

    @Resource
    private BuyCarBeanMapper buyCarBeanMapper;

    /**
     * 查询买车列表
     * @return
     */
    @Override
    public List<BuyCarBean> getBuyCarList(BuyCarBean buyCarBean) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("buyCarBean",buyCarBean);
        List<BuyCarBean> list=buyCarBeanMapper.getBuyCarList(map);
        return list;
    }

    /**
     * 查询数据库的数据总条数
     * @return
     */
    @Override
    public Long queryCountList() {
        return buyCarBeanMapper.queryCountList();
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public List<BuyCarBean> findUserList(Map map) {
        return buyCarBeanMapper.findUserList(map);
    }

    /**
     * 新增数据
     * @return
     */
    @Override
    public void insertMany(List<BuyCarBean> list) {
        buyCarBeanMapper.insertMany(list);
    }

    /**
     * 查询买车列表根据Id
     * @return
     */
    @Override
    public BuyCarBean getBuyCarListOne(Integer id) {
        return buyCarBeanMapper.getBuyCarListOne(id);
    }
    /**
     * 查询列表总条数
     * @return
     */
    @Override
    public int getBuyCarListCount() {
        return buyCarBeanMapper.getBuyCarListCount();
    }

    /**
     * 买车首页Highchars根据年
     * @return
     */
    @Override
    public List<Map<String, Object>> getBuyCarHighcharsYear() {
        return buyCarBeanMapper.getBuyCarHighcharsYear();
    }

    @Override
    public BuyCarBean getBuyCarListById(BuyCarBean buyCarBean) {
        return buyCarBeanMapper.getBuyCarListById(buyCarBean);
    }

    @Override
    public void addBuyCarStatus(BuyCarBean buyCarBean) {
        buyCarBeanMapper.addBuyCarStatus(buyCarBean);
    }

}
