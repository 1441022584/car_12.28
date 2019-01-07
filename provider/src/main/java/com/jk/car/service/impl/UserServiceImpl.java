/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/1 17:35
 * Description: 接口实现类
 * History:
 */
package com.jk.car.service.impl;

import com.jk.car.mapper.CarMapper;
import com.jk.car.mapper.UserMapper;
import com.jk.car.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈接口实现类〉
 *
 * @author admin
 * @create 2019/1/1
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private CarMapper carMapper;



}
