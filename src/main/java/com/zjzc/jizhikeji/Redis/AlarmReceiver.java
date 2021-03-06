package com.zjzc.jizhikeji.Redis;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlarmReceiver extends AbstractReceiver{
    @Override
    public void receiverMessage(Object message) {
        log.info("接收到的告警消息：{}", JSON.toJSONString(message));
    }
}
