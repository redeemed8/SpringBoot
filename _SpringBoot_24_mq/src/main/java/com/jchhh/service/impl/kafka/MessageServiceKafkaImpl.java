package com.jchhh.service.impl.kafka;

import com.jchhh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列(kafka)，id: " + id);
        kafkaTemplate.send("jchhh", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
