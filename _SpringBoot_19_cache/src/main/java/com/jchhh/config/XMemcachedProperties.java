package com.jchhh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {

    private String servers;

    private int poolSize;

    private long opTimeOut;

}
