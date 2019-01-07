package com.jk.car.utils;

import java.util.Random;

/*
 * @Author : 乔光辉
 * @Date : 2019/1/2$ 14:19$
 * @Description : $
 */
public class RandomCode {

    /**
     * 随机生成6位验证码
     * @return
     */
    public  String getRandomCode(Integer code){
        Random random = new Random();
        StringBuffer result= new StringBuffer();
        for (int i=0;i<code;i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

}
