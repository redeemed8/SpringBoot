package com.jchhh.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id) {
        System.out.println("已完成短信发送业务，id: " + id);
        //  将方法的返沪值 塞到 sendTo转发的消息队列中
        return "new: " + id;
    }

}
