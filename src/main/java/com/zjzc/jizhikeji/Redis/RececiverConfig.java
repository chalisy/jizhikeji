package com.zjzc.jizhikeji.Redis;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 订阅者者配置
 */
//@Configuration
public class RececiverConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter AlarmListenerAdapter,MessageListenerAdapter OnlineListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(AlarmListenerAdapter, new PatternTopic("NBMessageCTCC"));
        container.addMessageListener(OnlineListenerAdapter, new PatternTopic("NBMessageCTCC"));
        return container;
    }

    @Bean
    public MessageListenerAdapter AlarmListenerAdapter(AlarmReceiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }

    @Bean
    public MessageListenerAdapter OnlineistenerAdapter(OnlineReceiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }

    @Bean
    public AlarmReceiver alarmReceiver(){
        return new AlarmReceiver();
    }

    @Bean
    public OnlineReceiver onlineReceiver(){
        return new OnlineReceiver();
    }
}
