package com.bxia.bookstore.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


public enum Gender {

    MALE("男", 0),
    FEMALE("女", 1),
    UNKNOWN("未知", -1);

    private String desc;

    @EnumValue
    private Integer code;

    Gender(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    @JsonValue
    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    public static Gender valueOf(Integer code){
        for (Gender gender : values()){
            if (gender.getCode().equals(code)){
                return gender;
            }
        }
        return UNKNOWN;
    }
}
