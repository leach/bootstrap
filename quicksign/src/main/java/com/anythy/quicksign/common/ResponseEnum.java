package com.anythy.quicksign.common;

/**
 * Created by Leach on 0026 2017/7/26.
 */
public enum ResponseEnum {
    SUCCESS(1000, "操作成功"),
    ERROR_PARAM(1001, "参数错误"),
    ERROR_INNER(1002, "内部错误");

    private int code;
    private String message;

    ResponseEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getName(int code) {
        for (ResponseEnum c : ResponseEnum.values()) {
            if (c.getCode() == code) {
                return c.message;
            }
        }
        return "程序错误！";
    }
}
