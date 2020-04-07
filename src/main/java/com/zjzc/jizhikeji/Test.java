package com.zjzc.jizhikeji;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjzc.jizhikeji.DataHandler.DataMsgHandler;
import com.zjzc.jizhikeji.DataHandler.DataZJZC;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.AlarmQueue;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.ParamEntity;
import com.zjzc.jizhikeji.Redis.AlarmMessage;
import com.zjzc.jizhikeji.Redis.PublishConfig;
import com.zjzc.jizhikeji.Redis.Publisher;
import com.zjzc.jizhikeji.Util.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws ParseException {

        UtilTool util = new UtilTool();
        DataZJZC dataZJZC = new DataZJZC();
        DataMsgHandler dataMsgHandler = new DataMsgHandler();


//        AlarmQueue alarmQueue = new AlarmQueue();
//        AlarmQueue.Params params = new AlarmQueue.Params();
//
//        int num = 0;
//
//        alarmQueue.setVersion(0);
//        alarmQueue.setApi("uploadAlarm");
//        List<ParamEntity> dataArray = new ArrayList<>();
//        for(int i = 0;i <= 4;i++){
//            ParamEntity param = new ParamEntity();
//            param.setGatewayCode("Test"+i+"code");
//            param.setType(3);
//            param.setDeviceCode("001");
//            param.setDeviceType("test"+i+"type");
//            param.setAlarmType(i+1);
//            param.setAlarmState(i+2);
//            param.setUploadTime("201505020108");
//            param.setReceiveTime("20201031727");
//            num++;
//
//            dataArray.add(param);
//        }
//        alarmQueue.setDsize(num);
//
//        JSON ParamObject = (JSON) JSONArray.toJSON(dataArray);
//        params.setData(ParamObject);
//        alarmQueue.setParams(params);
//
//        JSONObject AlarmJson = (JSONObject) JSONObject.toJSON(alarmQueue);
//        String AlarmString = JSON.toJSONString(AlarmJson, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
//        System.out.println(AlarmString);

//        String a = "{\"notifyType\": \"deviceDataChanged\",\n" +
//                "\n" +
//                "\t\"requestId\": \"*************\",\n" +
//                "\n" +
//                "\t\"deviceId\": \"testdeviceid\",\n" +
//                "\n" +
//                "\t\"gatewayId\": \"123456\",\n" +
//                "\n" +
//                "\t\"service\": {\n" +
//                "\n" +
//                "\t\t\"serviceId\": \"test\",\n" +
//                "\n" +
//                "\t\t\"serviceType\": \"test\",\n" +
//                "\n" +
//                "\t\t\"data\": {\n" +
//                "\n" +
//                "\t\t\t\"Alarm\": \"3A2F02060A001E0000000DD80D000004\"\n" +
//                "\n" +
//                "\t\t},\n" +
//                "\n" +
//                "\t\t\"eventTime\": \"20170311T163657Z\"\n" +
//                "\n" +
//                "\t}}";
//        JSONObject jsonMsg = JSON.parseObject(a);
//        String alarmJson = dataMsgHandler.AlarmDataHandle(jsonMsg);
//        String alarmzjzc = dataZJZC.AlarmZJZC(alarmJson,jsonMsg);
//        System.out.println(alarmzjzc);


        //String a = dataMsgHandler.AlarmDataHandle(jsonObject);
        //String b = dataZJZC.AlarmZJZC(a,);

        //System.out.println(b);


    }
}
