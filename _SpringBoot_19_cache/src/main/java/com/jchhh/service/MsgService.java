package com.jchhh.service;

public interface MsgService {

    public String get(String telephone);

    public boolean check(String telephone, String code);

}
