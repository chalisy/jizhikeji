package com.zjzc.jizhikeji.DataHandler;

import com.alibaba.fastjson.JSONObject;
import com.zjzc.jizhikeji.MessagePackage.AlarmEntity;
import com.zjzc.jizhikeji.MessagePackage.HeartEntity;
import com.zjzc.jizhikeji.MessagePackage.RegisterEntity;
import com.zjzc.jizhikeji.Util.UtilTool;

public class DataMsgHandler {

    UtilTool utilTool = new UtilTool();
    /**
     * 心跳包处理
     * @param jsonMsg
     * @return
     */
    public String HeartDataHandle(JSONObject jsonMsg){

        HeartEntity heartEntity = new HeartEntity();
        HeartEntity.MessageData messageData = new HeartEntity.MessageData();
        HeartEntity.MessageData.ECI eci = new HeartEntity.MessageData.ECI();

        String HeartMsg = jsonMsg.getJSONObject("service").getJSONObject("data").getString("Heart");
        //String eventTime = jsonMsg.getJSONObject("service").getString("eventTime");

        heartEntity.setFrameHead(HeartMsg.substring(0,4));
        heartEntity.setFrameID(HeartMsg.substring(4,6));
        heartEntity.setCommandBit(HeartMsg.substring(6,8));
        heartEntity.setDataLength(HeartMsg.substring(8,10));
        messageData.setStatusBit(HeartMsg.substring(10,14));
        messageData.setSensitivity(HeartMsg.substring(14,16));
        messageData.setSensorPara(HeartMsg.substring(16,20));
        messageData.setSignal(HeartMsg.substring(20,22));
        messageData.setBattery(HeartMsg.substring(22,26));
        eci.seteNodeID(HeartMsg.substring(26,32));
        eci.setCELLID(HeartMsg.substring(32,34));
        messageData.setRSRP(HeartMsg.substring(34,38));
        messageData.setPCI(HeartMsg.substring(38,42));
        messageData.setSNR(HeartMsg.substring(42,46));
        messageData.setECL(HeartMsg.substring(46,48));
        heartEntity.setCheck(HeartMsg.substring(48,50));

        messageData.setEci(eci);
        heartEntity.setMessageData(messageData);
        String heartJson = utilTool.jsonFormat(heartEntity.toString());

        return heartJson;
    }

    /**
     * 注册包处理
     * @param jsonMsg
     * @return
     */
    public String RegisterDataHandle(JSONObject jsonMsg){

        RegisterEntity registerEntity = new RegisterEntity();
        RegisterEntity.MessageData messageData = new RegisterEntity.MessageData();

        String RegisterMsg = jsonMsg.getJSONObject("service").getJSONObject("data").getString("Register");
        //String eventTime = jsonMsg.getJSONObject("service").getString("eventTime");

        registerEntity.setFrameHead(RegisterMsg.substring(0,4));
        registerEntity.setFrameID(RegisterMsg.substring(4,6));
        registerEntity.setCommandBit(RegisterMsg.substring(6,8));
        registerEntity.setDataLength(RegisterMsg.substring(8,10));
        messageData.setProductType(RegisterMsg.substring(10,12));
        messageData.setProtocolVersion(RegisterMsg.substring(12,14));
        messageData.setProductModel(RegisterMsg.substring(14,16));
        messageData.setModuleInfo(RegisterMsg.substring(16,18));
        messageData.setSIMIMSI(RegisterMsg.substring(18,34));
        messageData.setManuInfo(RegisterMsg.substring(34,36));
        messageData.setHVersion(RegisterMsg.substring(36,38));
        messageData.setSVersion(RegisterMsg.substring(38,40));
        registerEntity.setCheck(RegisterMsg.substring(40,42));

        registerEntity.setMessageData(messageData);

        return registerEntity.toString();
    }

    /**
     * 告警包处理
     * @param jsonMsg
     * @return
     */
    public String AlarmDataHandle(JSONObject jsonMsg){

        AlarmEntity alarmEntity = new AlarmEntity();
        AlarmEntity.MessageData messageData = new AlarmEntity.MessageData();

        String AlarmMsg = jsonMsg.getJSONObject("service").getJSONObject("data").getString("Alarm");
        //String eventTime = jsonMsg.getJSONObject("service").getString("eventTime");

        alarmEntity.setFrameHead(AlarmMsg.substring(0,4));
        alarmEntity.setFrameID(AlarmMsg.substring(4,6));
        alarmEntity.setCommandBit(AlarmMsg.substring(6,8));
        alarmEntity.setDataLength(AlarmMsg.substring(8,10));
        messageData.setStatusBit(AlarmMsg.substring(10,14));
        messageData.setSensitivity(AlarmMsg.substring(14,16));
        messageData.setSensorPara(AlarmMsg.substring(16,20));
        messageData.setSignal(AlarmMsg.substring(20,22));
        messageData.setBattery(AlarmMsg.substring(22,26));
        messageData.setRetain(AlarmMsg.substring(26,30));
        alarmEntity.setCheck(AlarmMsg.substring(30,32));

        alarmEntity.setMessageData(messageData);
        String alarmJson = utilTool.jsonFormat(alarmEntity.toString());
        //System.out.println(alarmJson);

        return alarmJson;
    }
}
