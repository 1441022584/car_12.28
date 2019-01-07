package com.jk.car.service;

import com.jk.car.model.ParamsBean;

import java.util.List;

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
public interface ParamsService {

    /**
     * 查询买车参数
     * @return
     */
    List<ParamsBean> getBuyCarParam(Integer id);
}
