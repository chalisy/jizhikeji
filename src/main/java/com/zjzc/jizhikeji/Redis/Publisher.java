package com.zjzc.jizhikeji.Redis;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
    private final RedisTemplate<String, Object> redisMessageTemplate;

    @Autowired
    public Publisher(RedisTemplate<String, Object> redisMessageTemplate) {
        this.redisMessageTemplate = redisMessageTemplate;
    }

    public void pushAlarmMessage(String topic, AlarmMessage message) {
        redisMessageTemplate.convertAndSend(topic,message);
    }

    public void pushOnlineMessage(String topic, OnlineMessage message) {
        redisMessageTemplate.convertAndSend(topic,message);
    }
}
