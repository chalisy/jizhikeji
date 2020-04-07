package com.zjzc.jizhikeji.Redis;

import lombok.Data;
import lombok.EqualsAndHashCode;


public class AlarmMessage {

    public String code;
    public String status;
    public Long time;

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
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
