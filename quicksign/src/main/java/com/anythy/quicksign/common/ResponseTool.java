package com.anythy.quicksign.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leach on 0026 2017/7/26.
 */
public class ResponseTool {
    public static ResultData<Map<String, Object>> responseSucess(){
        return responseResult(true, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }
    public static ResultData<Map<String, Object>> responseInnerError(){
        return responseResult(false, ResponseEnum.ERROR_INNER.getCode(), ResponseEnum.ERROR_INNER.getMessage());
    }
    public static ResultData<Map<String, Object>> responseParamError(){
        return responseResult(false, ResponseEnum.ERROR_PARAM.getCode(), ResponseEnum.ERROR_PARAM.getMessage());
    }
    public static ResultData<Map<String, Object>> responseResult(boolean success, int code, String message){
        Map<String, Object> data = new HashMap<>();
        data.put("code", code);
        data.put("message", message);
        ResultData<Map<String, Object>> result = new ResultData<>(data, success);
        return result;
    }
}
