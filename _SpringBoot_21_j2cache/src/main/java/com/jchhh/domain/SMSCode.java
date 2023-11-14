package com.jchhh.domain;

import lombok.Data;

@Data
public class SMSCode {

    private String tele;
    private String code;

    public SMSCode() {
    }

    public SMSCode(String tele, String code) {
        this.tele = tele;
        this.code = code;
    }
}
