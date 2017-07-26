package com.anythy.quicksign.common;

import java.util.Map;

/**
 * Created by Leach on 0025 2017/7/25.
 */
public class ResultData<T> {
    private T data;
    private boolean success;

    public ResultData(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
