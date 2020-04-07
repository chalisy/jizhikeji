package com.zjzc.jizhikeji.MessagePackage.ZJZCEntity;

public class ParamEntity {
        private String gatewayCode;
        private int type;
        private String deviceCode = "";
        private String deviceType = "";
        private int alarmType;
        private int alarmState;
        private String uploadTime;
        private String receiveTime;

    @Override
    public String toString() {
        return "{" +
                "gatewayCode:'" + gatewayCode + '\'' +
                ", type:" + type +
                ", deviceCode:'" + deviceCode + '\'' +
                ", deviceType:'" + deviceType + '\'' +
                ", alarmType:" + alarmType +
                ", alarmState:" + alarmState +
                ", uploadTime:'" + uploadTime + '\'' +
                ", receiveTime:'" + receiveTime + '\'' +
                '}';
    }

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

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public int getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(int alarmState) {
        this.alarmState = alarmState;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }
}
