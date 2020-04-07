package com.zjzc.jizhikeji.MessagePackage;

public class RegisterEntity {
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
        //产品类型
        private String ProductType;
        //协议版本
        private String ProtocolVersion;
        //产品型号
        private String ProductModel;
        //模组信息
        private String ModuleInfo;
        //SIM卡IMSI
        private String SIMIMSI;
        //厂家信息
        private String ManuInfo;
        //硬件版本
        private String HVersion;
        //软件版本
        private String SVersion;

        @Override
        public String toString() {
            return "{" +
                    "ProductType:'" + ProductType + '\'' +
                    ", ProtocolVersion:'" + ProtocolVersion + '\'' +
                    ", ProductModel:'" + ProductModel + '\'' +
                    ", ModuleInfo:'" + ModuleInfo + '\'' +
                    ", SIMIMSI:'" + SIMIMSI + '\'' +
                    ", ManuInfo:'" + ManuInfo + '\'' +
                    ", HVersion:'" + HVersion + '\'' +
                    ", SVersion:'" + SVersion + '\'' +
                    '}';
        }

        public String getProductType() {
            return ProductType;
        }

        public void setProductType(String productType) {
            ProductType = productType;
        }

        public String getProtocolVersion() {
            return ProtocolVersion;
        }

        public void setProtocolVersion(String protocolVersion) {
            ProtocolVersion = protocolVersion;
        }

        public String getProductModel() {
            return ProductModel;
        }

        public void setProductModel(String productModel) {
            ProductModel = productModel;
        }

        public String getModuleInfo() {
            return ModuleInfo;
        }

        public void setModuleInfo(String moduleInfo) {
            ModuleInfo = moduleInfo;
        }

        public String getSIMIMSI() {
            return SIMIMSI;
        }

        public void setSIMIMSI(String SIMIMSI) {
            this.SIMIMSI = SIMIMSI;
        }

        public String getManuInfo() {
            return ManuInfo;
        }

        public void setManuInfo(String manuInfo) {
            ManuInfo = manuInfo;
        }

        public String getHVersion() {
            return HVersion;
        }

        public void setHVersion(String HVersion) {
            this.HVersion = HVersion;
        }

        public String getSVersion() {
            return SVersion;
        }

        public void setSVersion(String SVersion) {
            this.SVersion = SVersion;
        }
    }
}
