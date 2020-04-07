package com.zjzc.jizhikeji.MessagePackage.ZJZCEntity;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

public class AlarmQueue {
    private int version;
    private String api;
    private Params params;
    private int dsize;

    @Override
    public String toString() {
        return "{" +
                "version:" + version +
                ", api:'" + api + '\'' +
                ", params:" + params +
                ", dsize:" + dsize +
                '}';
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public int getDsize() {
        return dsize;
    }

    public void setDsize(int dsize) {
        this.dsize = dsize;
    }

    public static class Params{
        public JSON data;

        @Override
        public String toString() {
            return "{" +
                    "data:'" + data + '\'' +
                    '}';
        }

        public JSON getData() {
            return data;
        }

        public void setData(JSON data) {
            this.data = data;
        }
    }
}
