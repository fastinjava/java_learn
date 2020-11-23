package com.fastdevelop.rabbit_mq_provider.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    //Fanout交换机 起名：TestFanoutExchange
    @Bean
    FanoutExchange TestFanoutExchange() {
        return new FanoutExchange("TestFanoutExchange",true,false);
    }

    @Bean
    public Queue TestFanoutQueue(){
        return new Queue("TestFanoutQueue",true);
    }

    @Bean
    public Queue TestFanoutQueue1(){
        return new Queue("TestFanoutQueue1",true);
    }


    @Bean
    public Binding bindingFanout(){
        return BindingBuilder.bind(TestFanoutQueue()).to(TestFanoutExchange());
    }

    @Bean
    public Binding bindingFanout1(){
        return BindingBuilder.bind(TestFanoutQueue1()).to(TestFanoutExchange());
    }


}
