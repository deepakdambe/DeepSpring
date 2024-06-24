package com.example.SocialProjectYoutube.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ReturnValue {

    RV_SUCCESS(0, "SUCCESS"),
    RV_FAIL(1, "FAIL");


    private int errCode;
    private String errMessage;
}
