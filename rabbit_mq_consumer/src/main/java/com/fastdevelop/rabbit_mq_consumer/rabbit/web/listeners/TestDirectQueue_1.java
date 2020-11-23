package com.fastdevelop.rabbit_mq_consumer.rabbit.web.listeners;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queues = {"TestDirectQueue"})
public class TestDirectQueue_1 {
    @RabbitHandler
    public void process(Map message) {
        log.info("TestDirectQueue_1 =========== TestDirectQueue 消息队列消费消息,当前消息内容为: {} ", JSONUtil.toJsonPrettyStr(message));
    }
}
