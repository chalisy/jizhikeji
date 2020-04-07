package com.zjzc.jizhikeji.DataHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.AlarmQueue;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.OnlineQueue;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.ParamEntity;
import com.zjzc.jizhikeji.Util.UtilTool;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataZJZC {

    UtilTool utilTool = new UtilTool();

    public String AlarmZJZC(String alarmJson, JSONObject jsonMsg) throws ParseException {

        JSONObject alarmMsg = JSONObject.parseObject(alarmJson);
        AlarmQueue alarmQueue = new AlarmQueue();
        AlarmQueue.Params params = new AlarmQueue.Params();

        alarmQueue.setVersion(0);
        alarmQueue.setApi("uploadAlarm");
        String data = alarmMsg.getJSONObject("messageData").getString("StatusBit");
//        String StatusData = utilTool.StatusMsgHandle(data);
//        int dsize = 0;
//        for(int i = 0;i < StatusData.length();i++){
//            if(StatusData.charAt(i)=='1'){
//                dsize++;
//            }
//        }
        alarmQueue.setDsize(1);
        if(alarmMsg.getString("CommandBit").equals("03")){
            params.setData(utilTool.param(jsonMsg,2,103));
        }
        if(alarmMsg.getString("CommandBit").equals("04")){
            params.setData(utilTool.param(jsonMsg,1,1));
        }
        if(alarmMsg.getString("CommandBit").equals("05")){
            params.setData(utilTool.param(jsonMsg,1,3));
        }
        if(alarmMsg.getString("CommandBit").equals("06")){
            params.setData(utilTool.param(jsonMsg,2,306));
        }
        if(alarmMsg.getString("CommandBit").equals("07")){
            params.setData(utilTool.param(jsonMsg,2,101));
        }
        if(alarmMsg.getString("CommandBit").equals("08")){
            params.setData(utilTool.param(jsonMsg,2,106));
        }
        if(alarmMsg.getString("CommandBit").equals("09")){
            params.setData(utilTool.param(jsonMsg,2,1));
        }
//        List<ParamEntity> dataArray = new ArrayList<>();
//        String[] bit = StatusData.split("");
//
//        if(bit[15].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,1,1));
//        }
//        if(bit[14].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,2,101));
//        }
//        if(bit[13].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,2,1));
//        }
//        if(bit[12].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,2,103));
//        }
//        if(bit[11].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,2,106));
//        }
//        if(bit[10].equals("1")){
//            dataArray.add(utilTool.param(jsonMsg,1,5));
//        }
//
//        JSON ParamObject = (JSON) JSONArray.toJSON(dataArray);
//        params.setData(ParamObject);
        alarmQueue.setParams(params);

        JSONObject AlarmJson = (JSONObject) JSONObject.toJSON(alarmQueue);
        String AlarmString = JSON.toJSONString(AlarmJson, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        System.out.println("告警数据为："+AlarmString);
        return AlarmString;
    }

    /**
     * 不做格式化处理
     * @return
     */
    public String RegisterZJZC(){

        return null;
    }

    public String OnlineZJZC(JSONObject bodyMsg){

        OnlineQueue onlineQueue = new OnlineQueue();
        OnlineQueue.Params params = new OnlineQueue.Params();

        onlineQueue.setVersion(0);
        onlineQueue.setApi("uploadOnline");
        params.setGatewayCode(bodyMsg.getString("deviceId"));
        params.setType(2);
        if(bodyMsg.getJSONObject("deviceInfo").getString("status").equals("ONLINE")) {
            params.setOnlineStatus(0);
        } else if(bodyMsg.getJSONObject("deviceInfo").getString("status").equals("OFFLINE")){
            params.setOnlineStatus(1);
        }
        String dateStr = Long.toString(System.currentTimeMillis());
        params.setTime(dateStr);
        onlineQueue.setDsize(1);
        onlineQueue.setParams(params);

        JSONObject OnlineJson = (JSONObject) JSONObject.toJSON(onlineQueue);
        String OnlineString = JSON.toJSONString(OnlineJson, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        System.out.println("上线数据为："+OnlineString);
        return OnlineString;
    }

    public String HeartZJZC(String heartJson, JSONObject jsonMsg) throws ParseException {

        return null;
    }
}
