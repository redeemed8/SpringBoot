package com.jchhh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@Data
@ConfigurationProperties(prefix = "servers")        //   支持宽松绑定
@Validated              //  开启对当前 bean的属性注入校验
public class ServerConfig {

    private String ipAddress;
    @Max(value = 8888, message = "最大不能超过8888")
    @Min(value = 202,message = "最小不能低于202")
    private int port;
    private long timeout;           //  服务器超时时间
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
    @DataSizeUnit(DataUnit.MEGABYTES)       //  也可以不写这个注解，直接在配置文件里数字后加上单位即可
    private DataSize dataSize;

}
