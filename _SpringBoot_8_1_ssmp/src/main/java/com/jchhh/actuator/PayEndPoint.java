package com.jchhh.actuator;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay() {
        System.out.println("====================");
        System.out.println("=========Pay========");
        System.out.println("====================");

        Map<String, Object> payMap = new HashMap<>();
        payMap.put("level 1", "300");
        payMap.put("level 2", "291");
        payMap.put("level 3", "666");
        return payMap;          //  可自动转换成 json格式
    }

}
