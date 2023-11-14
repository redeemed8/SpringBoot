package com.jchhh.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoConfig implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        //  单添加
        builder.withDetail("runTime", System.currentTimeMillis());

        //  多添加
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("buildTime", "2006");
        builder.withDetails(infoMap);
    }

}
