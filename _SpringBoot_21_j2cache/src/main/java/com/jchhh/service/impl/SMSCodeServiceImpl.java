package com.jchhh.service.impl;

import com.jchhh.domain.SMSCode;
import com.jchhh.service.SMSCodeService;
import com.jchhh.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    //  定义一个缓存对象
    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms", tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms", smsCode.getTele()).asString();
        return smsCode.getCode().equals(code);
    }

}
