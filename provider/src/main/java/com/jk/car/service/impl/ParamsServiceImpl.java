package com.jk.car.service.impl;

import com.jk.car.mapper.ParamsBeanMapper;
import com.jk.car.model.ParamsBean;
import com.jk.car.service.ParamsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service("paramsService")
public class ParamsServiceImpl implements ParamsService {
    @Resource
    private ParamsBeanMapper paramsBeanMapper;

    /**
     * 查询买车参数
     * @return
     */
    @Override
    public List<ParamsBean> getBuyCarParam(Integer id) {
        return paramsBeanMapper.getBuyCarParam(id);
    }
}
