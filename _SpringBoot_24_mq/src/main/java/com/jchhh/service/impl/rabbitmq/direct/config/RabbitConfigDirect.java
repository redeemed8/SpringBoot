package com.jchhh.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfigDirect {

    //  造一个消息队列
    @Bean
    public Queue directQueue() {
        return new Queue("direct_queue");
        //      return new Queue("direct_queue", true, true, true);
        //                                      持久化|连接是否专用|是否删除
    }

    //  造一个交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    //  绑定消息队列和交换机
//    @Bean
//    public Binding bindingDirect() {
//        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
//    }

}
