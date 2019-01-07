/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2018/12/25 11:35
 * Description: rabbitmq
 * History:
 */
package com.jk.car.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈rabbitmq〉
 * @author admin
 * @create 2018/12/25
 * @since 1.0.0
 */
@Configuration
public class rabbitConfig {

    @Bean
    public Queue queueMessage(){

        return new Queue("addBuyCarWY");

    }
}
