package com.zjzc.jizhikeji.MessagePackage;

public class AlarmEntity {

    //帧头
    private String FrameHead;
    //帧ID
    private String FrameID;
    //命令位
    private String CommandBit;
    //数据长度
    private String DataLength;
    //数据
    private MessageData messageData;
    //校验
    private String Check;

    @Override
    public String toString() {
        return "{" +
                "FrameHead:'" + FrameHead + '\'' +
                ", FrameID:'" + FrameID + '\'' +
                ", CommandBit:'" + CommandBit + '\'' +
                ", DataLength:'" + DataLength + '\'' +
                ", messageData:" + messageData +
                ", Check:'" + Check + '\'' +
                '}';
    }

    public String getFrameHead() {
        return FrameHead;
    }

    public void setFrameHead(String frameHead) {
        FrameHead = frameHead;
    }

    public String getFrameID() {
        return FrameID;
    }

    public void setFrameID(String frameID) {
        FrameID = frameID;
    }

    public String getCommandBit() {
        return CommandBit;
    }

    public void setCommandBit(String commandBit) {
        CommandBit = commandBit;
    }

    public String getDataLength() {
        return DataLength;
    }

    public void setDataLength(String dataLength) {
        DataLength = dataLength;
    }

    public MessageData getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    public String getCheck() {
        return Check;
    }

    public void setCheck(String check) {
        Check = check;
    }

    public static class MessageData{
        //状态位
        private String StatusBit;
        //灵敏度
        private String Sensitivity;
        //传感器参数
        private String SensorPara;
        //信号强度
        private String Signal;
        //电池电量
        private String Battery;
        //保留
        private String retain;

        @Override
        public String toString() {
            return "{" +
                    "StatusBit:'" + StatusBit + '\'' +
                    ", Sensitivity:'" + Sensitivity + '\'' +
                    ", SensorPara:'" + SensorPara + '\'' +
                    ", Signal:'" + Signal + '\'' +
                    ", Battery:'" + Battery + '\'' +
                    ", retain:'" + retain + '\'' +
                    '}';
        }

        public String getStatusBit() {
            return StatusBit;
        }

        public void setStatusBit(String statusBit) {
            StatusBit = statusBit;
        }

        public String getSensitivity() {
            return Sensitivity;
        }

        public void setSensitivity(String sensitivity) {
            Sensitivity = sensitivity;
        }

        public String getSensorPara() {
            return SensorPara;
        }

        public void setSensorPara(String sensorPara) {
            SensorPara = sensorPara;
        }

        public String getSignal() {
            return Signal;
        }

        public void setSignal(String signal) {
            Signal = signal;
        }

        public String getBattery() {
            return Battery;
        }

        public void setBattery(String battery) {
            Battery = battery;
        }

        public String getRetain() {
            return retain;
        }

        public void setRetain(String retain) {
            this.retain = retain;
        }
    }
}
