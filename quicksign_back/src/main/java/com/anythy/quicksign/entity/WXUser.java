package com.anythy.quicksign.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Leach on 0026 2017/7/26.
 */
public class WXUser implements Serializable {
    @NotNull(message = "Constants.PARAM_ERROR")
    private String openId;
    @NotNull(message = "Constants.PARAM_ERROR")
    private String nickName;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
