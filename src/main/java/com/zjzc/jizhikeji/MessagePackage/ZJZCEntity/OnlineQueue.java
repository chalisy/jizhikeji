package com.zjzc.jizhikeji.MessagePackage.ZJZCEntity;

public class OnlineQueue {
    private int version;
    private String api;
    private Params params;
    private int dsize;

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

    @Override
    public String toString() {
        return "{" +
                "version:" + version +
                ", api:'" + api + '\'' +
                ", params:" + "["+params +"]"+
                ", dsize:" + dsize +
                '}';
    }

    public static class Params{
        private String gatewayCode;
        private int type;
        private int onlineStatus;
        private String time;

        public String getGatewayCode() {
            return gatewayCode;
        }

        public void setGatewayCode(String gatewayCode) {
            this.gatewayCode = gatewayCode;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getOnlineStatus() {
            return onlineStatus;
        }

        public void setOnlineStatus(int onlineStatus) {
            this.onlineStatus = onlineStatus;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "{" +
                    "gatewayCode:'" + gatewayCode + '\'' +
                    ", type:" + type +
                    ", onlineStatus:" + onlineStatus +
                    ", time:" + time +
                    '}';
        }
    }
}
