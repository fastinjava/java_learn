package com.fastdevelop.rabbit_mq_consumer.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    /**
     * 创建名称为TestTopicExchange的TopicExchange类型的交换机
     * @return
     */
    @Bean
    TopicExchange TestTopicExchange(){
        return new TopicExchange("TestTopicExchange");
    }

    @Bean
    public Queue queueTopic1() {
        return new Queue("TestTopicQueue");
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue("TestTopicQueue1");
    }

    @Bean
    public Binding bindingTopic1(){
        return BindingBuilder.bind(queueTopic1()).to(TestTopicExchange()).with("topic.#");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(queueTopic2()).to(TestTopicExchange()).with("topic.*");
    }

}
