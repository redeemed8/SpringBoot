package com.jchhh.service.impl;

import com.jchhh.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String telephone) {
        String code = telephone.substring(telephone.length() - 6);
        cache.put(telephone, code);
        return code;
    }

    @Override
    public boolean check(String telephone, String code) {
        String queryCode = cache.get(telephone);
        return code.equals(queryCode);
    }
}
