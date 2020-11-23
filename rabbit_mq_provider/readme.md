# rabbitMQ(服务方) 消息队列学习
## rabbitMQ工作概念图

![](https://gitee.com/leefuyong/blogimg/raw/master/null/972319-20170311161512951-1006030113.png)

可见rabbitmq主要有四种角色；
1】生产者 p
2】交换机 exchange
3】消息队列 queue
4】消费者 c

主要是：生产者生产消息，将消息推送到交换机，交换机通过一定的调度策略推送到各种队列，
消费者监听到对应的消息队列有消息进来后进行消费。

## 交换机
交换机的主要作用是接收相应的消息并且绑定到指定的队列.交换机有四种类型,分别为Direct,topic,headers,Fanout.

Direct是RabbitMQ默认的交换机模式,也是最简单的模式.即创建消息队列的时候,指定一个BindingKey.当发送者发送消息的时候,指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.

topic转发信息主要是依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串),而当发送消息的时候,只有指定的Key和该模式相匹配的时候,消息才会被发送到该消息队列中.

headers也是根据一个规则进行匹配,在消息队列和交换机绑定的时候会指定一组键值对规则,而发送消息的时候也会指定一组键值对规则,当两组键值对规则相匹配的时候,消息会被发送到匹配的消息队列中.

Fanout是路由广播的形式,将会把消息发给绑定它的全部队列,即便设置了key,也会被忽略.


### 环境搭建
1、参考该工程pom.xml文件，消息队列部分;
2、application-dev.yml文件，消息队列部分;
3、配置文件&&如何测试，参考下面几个小节;

### Direct
1、编写配置类DirectRabbitConfig文件
2、创建交换机
```
    @Bean
    DirectExchange TestDirectExchange() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new DirectExchange("TestDirectExchange",true,false);
    }
```
3、创建(若干个)队列
```
    @Bean
    public Queue TestDirectQueue(){
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false

        return new Queue("TestDirectQueue",true);
    }

    @Bean
    public Queue TestDirectQueue1(){
        return new Queue("TestDirectQueue1",true);
    }


```

4、交换机和队列进行绑定
```textmate
    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }
    @Bean
    public Binding bindingDirect1(){
        return BindingBuilder.bind(TestDirectQueue1()).to(TestDirectExchange()).with("TestDirectRouting1");
    }
```

5、简单来说，通过以上配置做了些什么呢？一张图告诉你
![](https://gitee.com/leefuyong/blogimg/raw/master/null/20201123145245.png)

![](https://gitee.com/leefuyong/blogimg/raw/master/null/20201123151219.png)

### Fanout
Fanout交换机不需要routingkey绑定，和路由没有关系，它是直接绑定到队列的。
Fanout交换机直接绑定了队列，没有经过routingkey进行匹配之类的，相对来说是所有交换机中最快的。
1】创建FanoutRabbitConfig配置类文件；
2】创建交换机
```textmate

    //Fanout交换机 起名：TestFanoutExchange
    @Bean
    FanoutExchange TestFanoutExchange() {
        return new FanoutExchange("TestFanoutExchange",true,false);
    }

```
3】创建队列
```textmate

    @Bean
    public Queue TestFanoutQueue(){
        return new Queue("TestFanoutQueue",true);
    }

    @Bean
    public Queue TestFanoutQueue1(){
        return new Queue("TestFanoutQueue1",true);
    }

```

4】绑定队列
```textmate
    @Bean
    public Binding bindingFanout(){
        return BindingBuilder.bind(TestFanoutQueue()).to(TestFanoutExchange());
    }

    @Bean
    public Binding bindingFanout1(){
        return BindingBuilder.bind(TestFanoutQueue1()).to(TestFanoutExchange());
    }

```
5】发送队列
```textmate
 @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    //发送队列时，只需指定交换机即可，只要是绑定了该交换机的消息队列都会收到消息
    rabbitTemplate.convertAndSend("TestFanoutExchange", null,map);
```


### Topic

String routingkey = “testTopic.#”;
String routingkey = “testTopic.*”;

1]创建配置类TopicRabbitConfig文件
2】创建交换机TopicExchange
```textmate
 /**
     * 创建名称为TestTopicExchange的TopicExchange类型的交换机
     * @return
     */
    @Bean
    TopicExchange TestTopicExchange(){
        return new TopicExchange("TestTopicExchange");
    }
```
3]创建队列
```textmate
    @Bean
    public Queue queueTopic1() {
        return new Queue("TestTopicQueue");
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue("TestTopicQueue1");
    }
```
4]绑定队列
```textmate
    @Bean
    public Binding bindingTopic1(){
        return BindingBuilder.bind(queueTopic1()).to(TestTopicExchange()).with("topic.#");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(queueTopic2()).to(TestTopicExchange()).with("topic.*");
    }
```
5]发送队列
```textmate
    @GetMapping("/sendTopicMessage")
    public String sendTopicMessage() {
        Map<String,Object> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                map.put("messageData",i);
                rabbitTemplate.convertAndSend("TestTopicExchange", "topic.km.topic", map);
            } else {
                rabbitTemplate.convertAndSend("TestTopicExchange", "topic.km", map);
            }
        }
        return "ok";
    }
```

6]总结
![](https://gitee.com/leefuyong/blogimg/raw/master/null/20201123164129.png)
