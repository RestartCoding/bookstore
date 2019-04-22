package com.bxia.bookstore.web;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Builder
@Data
public class CommonResponse {

    private int status;

    private Object data;

    private String errMsg;

    public static CommonResponse ok(Object data){
        return builder()
                .status(HttpStatus.OK.value())
                .data(data)
                .errMsg(null)
                .build();
    }

    public static CommonResponse error(String errMsg){
        return builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data(null)
                .errMsg(errMsg)
                .build();
    }
}
