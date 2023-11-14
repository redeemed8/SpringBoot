package com.jchhh.service.impl;

import com.jchhh.domain.SMSCode;
import com.jchhh.service.SMSCodeService;
import com.jchhh.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @Override
////    @Cacheable(value = "smsCode",key = "#tele")
//    @CachePut(value = "smsCode", key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        //  取出内存中的验证码 和 缓存中的验证码进行比对，相同就返回 true
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }

//    以下是springboot使用Xmemcached

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele, 10, code);           //  0 代表永不过期
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            Object ret = memcachedClient.get(smsCode.getTele());
            if (ret != null) {
                code = ret.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }

}
