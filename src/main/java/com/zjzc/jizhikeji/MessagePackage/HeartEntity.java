package com.zjzc.jizhikeji.MessagePackage;

public class HeartEntity {
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

    @Override
    public String toString() {
        return "{" +
                "FrameHead:'" + FrameHead + '\'' +
                ", FrameID:'" + FrameID + '\'' +
                ", CommandBit:'" + CommandBit + '\'' +
                ", DataLength:'" + DataLength + '\'' +
                ", MessageData:" + messageData +
                ", Check:'" + Check + '\'' +
                '}';
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
        //ECI
        private ECI eci;
        //RSRP
        private String RSRP;
        //PCI
        private String PCI;
        //SNR
        private String SNR;
        //ECL
        private String ECL;

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

        public ECI getEci() {
            return eci;
        }

        public void setEci(ECI eci) {
            this.eci = eci;
        }

        public String getRSRP() {
            return RSRP;
        }

        public void setRSRP(String RSRP) {
            this.RSRP = RSRP;
        }

        public String getPCI() {
            return PCI;
        }

        public void setPCI(String PCI) {
            this.PCI = PCI;
        }

        public String getSNR() {
            return SNR;
        }

        public void setSNR(String SNR) {
            this.SNR = SNR;
        }

        public String getECL() {
            return ECL;
        }

        public void setECL(String ECL) {
            this.ECL = ECL;
        }

        @Override
        public String toString() {
            return "{" +
                    "StatusBit:'" + StatusBit + '\'' +
                    ", Sensitivity:'" + Sensitivity + '\'' +
                    ", SensorPara:'" + SensorPara + '\'' +
                    ", Signal:'" + Signal + '\'' +
                    ", Battery:'" + Battery + '\'' +
                    ", eci:" + eci +
                    ", RSRP:'" + RSRP + '\'' +
                    ", PCI:'" + PCI + '\'' +
                    ", SNR:'" + SNR + '\'' +
                    ", ECL:'" + ECL + '\'' +
                    '}';
        }

        public static class ECI{
            //eNodeB ID
            private String eNodeID;
            //CELLID
            private String CELLID;

            @Override
            public String toString() {
                return "{" +
                        "eNodeID:'" + eNodeID + '\'' +
                        ", CELLID:'" + CELLID + '\'' +
                        '}';
            }

            public String geteNodeID() {
                return eNodeID;
            }

            public void seteNodeID(String eNodeID) {
                this.eNodeID = eNodeID;
            }

            public String getCELLID() {
                return CELLID;
            }

            public void setCELLID(String CELLID) {
                this.CELLID = CELLID;
            }
        }
    }
}
