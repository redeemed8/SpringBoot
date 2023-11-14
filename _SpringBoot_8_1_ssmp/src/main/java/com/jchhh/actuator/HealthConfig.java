package com.jchhh.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HealthConfig extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;

        if (condition) {
            builder.status(Status.UP);
            //  单添加
            builder.withDetail("runTime", System.currentTimeMillis());

            //  多添加
            Map<String, Object> infoMap = new HashMap<>();
            infoMap.put("buildTime", "2006");
            builder.withDetails(infoMap);

            //  修改状态为 Up
            //  builder.up();
        } else {
            builder.status(Status.OUT_OF_SERVICE);
            builder.withDetail("上线了吗?", "你做梦");
            //  builder.down();
        }

    }

}
