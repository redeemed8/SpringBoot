package com.jchhh.service.impl.rocketmq;

import com.jchhh.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MessageServiceRocketmqImpl implements MessageService {

//    @Autowired
    private RocketMQTemplate rocketMQTemplate;

//    @Override
//    public void sendMessage(String id) {
//        System.out.println("待发送短信的订单已纳入处理队列(rocketmq)，id: " + id);
//        //  这是同步消息，不太好
//        rocketMQTemplate.convertAndSend("order_id", id);
//    }

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列(rocketmq)，id: " + id);
        //  这是异步消息

        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功...");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败!!!");
            }
        };
        rocketMQTemplate.asyncSend("order_id", id, callback);
    }

    @Override
    public String doMessage() {
        //  这种比较 low
        return null;
    }
}
