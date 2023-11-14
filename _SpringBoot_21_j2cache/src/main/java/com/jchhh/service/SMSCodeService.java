package com.jchhh.service;

import com.jchhh.domain.SMSCode;

public interface SMSCodeService {

    public String sendCodeToSMS(String tele);

    public boolean checkCode(SMSCode smsCode);

}
