package com.jk.car.controller;

import com.jk.car.model.ParamsBean;
import com.jk.car.service.ParamsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class ParamsController {
    @Resource
    private ParamsService paramsService;

    /**
     * 查询买车参数
     * @return
     */
    @RequestMapping("getBuyCarParam")
    @ResponseBody
    public List<ParamsBean> getBuyCarParam(Integer id){
        List<ParamsBean> buyCarBeanParam =  paramsService.getBuyCarParam(id);
        System.out.println(buyCarBeanParam);
        return buyCarBeanParam;
    }
}
