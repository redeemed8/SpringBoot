package com.jchhh.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfigTopic {

    //  造一个消息队列
    @Bean
    public Queue topicQueue() {
        return new Queue("topic_queue");
        //      return new Queue("topic_queue", true, true, true);
        //                                      持久化|连接是否专用|是否删除
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    //  造一个交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    //  绑定消息队列和交换机
//    @Bean
//    public Binding bindingTopic() {
//        //  * 表示占位任意           # 表示 后面随意  topic.#
//        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
//    }

//    @Bean
//    public Binding bindingTopic2() {
//        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic2");
//    }

}
