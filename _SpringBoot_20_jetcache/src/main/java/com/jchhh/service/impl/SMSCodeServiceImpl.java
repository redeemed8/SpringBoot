package com.jchhh.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.jchhh.domain.SMSCode;
import com.jchhh.service.SMSCodeService;
import com.jchhh.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    //  remote 远程缓存方案
//    @CreateCache(area = "sms", name = "jetCache", expire = 10, timeUnit = TimeUnit.SECONDS)
    //  expire是过期时间 单位是 秒(默认)

    @CreateCache(name = "jetCache", expire = 30, timeUnit = TimeUnit.SECONDS,cacheType = CacheType.BOTH)
    //  cacheType可以设置缓存类型    仅限本地 Local     仅限远程缓存 remote     两个同时使用 Both
    private Cache<String, String> jetcache;          //  要用 alicp包下的

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetcache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetcache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }

}
