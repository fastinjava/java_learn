package com.fastdevelop.rabbit_mq_consumer.rabbit.web.listeners;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queues = {"TestFanoutQueue"})
public class TestFanoutQueue_1 {
    @RabbitHandler
    public void process(Map message) {
        log.info("TestFanoutQueue_1 =========== TestFanoutQueue 消息队列消费消息,当前消息内容为: {} ", JSONUtil.toJsonPrettyStr(message));
    }
}
