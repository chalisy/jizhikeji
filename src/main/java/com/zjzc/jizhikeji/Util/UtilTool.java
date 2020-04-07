package com.zjzc.jizhikeji.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjzc.jizhikeji.MessagePackage.ZJZCEntity.ParamEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UtilTool {
    public String StatusMsgHandle(String StatusBit){

        //指定status字符串的数据为十六进制-----------radix为指定基数，16为十六进制
        //转换之后的到的statusInt值为十进制
        Integer statusInt = Integer.parseInt(StatusBit,16);
        //将十进制的statusInt整型值转换为二进制字符串
        String statusString = Integer.toBinaryString(statusInt);
        for(int i = 1;i <= 16;i++){
            if(statusString.length()<16){
                statusString = "0"+statusString;
            }
        }
        //System.out.println("正常二进制数为："+statusString);
        StringBuffer sb=new StringBuffer();
        sb.append(statusString);
        //将字符串倒序输出为StringBuffer类型
        StringBuffer revstatusString = sb.reverse();
        //System.out.println("倒序输出为:"+revstatusString);

        return statusString;
    }

    /**
     * json格式化
     * @param jsonString
     * @return
     */
    public String jsonFormat(String jsonString) {
        JSONObject object= JSONObject.parseObject(jsonString, Feature.OrderedField);
        jsonString = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        return jsonString;
    }

    public JSON param(JSONObject jsonMsg, int alarmType, int alarmState) throws ParseException {
        ParamEntity paramEntity = new ParamEntity();

        paramEntity.setGatewayCode(jsonMsg.getString("gatewayId"));
        paramEntity.setType(3);
        paramEntity.setDeviceCode(jsonMsg.getString("deviceId"));
        paramEntity.setAlarmType(alarmType);
        paramEntity.setAlarmState(alarmState);
        String time = jsonMsg.getJSONObject("service").getString("eventTime");
        time = time.replace("T","");
        time = time.replace("Z","");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Long epoch = simpleDateFormat.parse(time).getTime();
        paramEntity.setUploadTime(epoch.toString());
        String dateStr = Long.toString(System.currentTimeMillis());
        paramEntity.setReceiveTime(dateStr);

        return JSONObject.parseObject(String.valueOf(paramEntity));
    }

}
