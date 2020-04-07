package com.zjzc.jizhikeji.Redis;

import lombok.Data;
import lombok.EqualsAndHashCode;


public class OnlineMessage {
    public String code;
    public String imei;
    public String status;
    public Long time;

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", imei:'" + imei + '\'' +
                ", status:'" + status + '\'' +
                ", time:" + time +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
