package com.zjzc.jizhikeji.DataHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjzc.jizhikeji.Redis.AlarmMessage;
import com.zjzc.jizhikeji.Redis.OnlineMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DecentZJZC {
    public AlarmMessage Alarm(String alarmJson, JSONObject jsonMsg) throws ParseException {
        JSONObject alarmMsg = JSONObject.parseObject(alarmJson);
        AlarmMessage alarmMessage = new AlarmMessage();
        alarmMessage.setCode(jsonMsg.getString("deviceId"));
        if(alarmMsg.getString("CommandBit").equals("03")){
            alarmMessage.setStatus("apart");
        }
        if(alarmMsg.getString("CommandBit").equals("04")){
            alarmMessage.setStatus("alarm");
        }
        if(alarmMsg.getString("CommandBit").equals("05")){
            alarmMessage.setStatus("alarmRemove");
        }
        if(alarmMsg.getString("CommandBit").equals("06")){
            alarmMessage.setStatus("testAlarm");
        }
        if(alarmMsg.getString("CommandBit").equals("07")){
            alarmMessage.setStatus("lowPower");
        }
        if(alarmMsg.getString("CommandBit").equals("08")){
            alarmMessage.setStatus("alarmSilence");
        }
        if(alarmMsg.getString("CommandBit").equals("09")){
            alarmMessage.setStatus("fault");
        }

        String time = jsonMsg.getJSONObject("service").getString("eventTime");
        time = time.replace("T","");
        time = time.replace("Z","");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Long epoch = simpleDateFormat.parse(time).getTime();

        alarmMessage.setTime(epoch);
        JSONObject AlarmJson = (JSONObject) JSONObject.toJSON(alarmMessage);
        String AlarmString = JSON.toJSONString(AlarmJson);
        System.out.println("告警数据为："+AlarmString);

        return alarmMessage;
    }

    public OnlineMessage Online(JSONObject jsonMsg){
        OnlineMessage onlineMessage = new OnlineMessage();
        onlineMessage.setCode(jsonMsg.getString("deviceId"));
        onlineMessage.setImei(jsonMsg.getJSONObject("deviceInfo").getString("nodeId"));

            if(jsonMsg.getJSONObject("deviceInfo").getString("status").equals("ONLINE")) {
                onlineMessage.setStatus("online");
            } else if(jsonMsg.getJSONObject("deviceInfo").getString("status").equals("OFFLINE")){
                onlineMessage.setStatus("offline");
            } else if(jsonMsg.getJSONObject("deviceInfo").getString("status").equals("ABNORMAL")){
                onlineMessage.setStatus("offline");
            } else{
                System.out.println("设备传输消息有误,消息详情为："+jsonMsg);
                return null;
            }
        Long dateStr = System.currentTimeMillis();
        onlineMessage.setTime(dateStr);
        JSONObject OnlineJson = (JSONObject) JSONObject.toJSON(onlineMessage);
        String OnlineString = JSON.toJSONString(OnlineJson);
        System.out.println("上下线数据为："+OnlineString);

        return onlineMessage;
    }
}
