package com.jk.car.mapper;

import com.jk.car.model.ParamsBean;

import java.util.List;

public interface ParamsBeanMapper {

    /**
     * 查询买车参数
     * @return
     */
    List<ParamsBean> getBuyCarParam(Integer id);
}