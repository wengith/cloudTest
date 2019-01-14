# 集成RabbitMQ
## 1. 引入rabbitmq的依赖

```  
     <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency> 

```
## 2.在src/main/resources里面新增application.yml
```
spring:
  application:
    name:springboot-rabbitmq
  rabbitmq:
    host:localhost
    port:5672
    username:guest
    password:guest
    publisher-confirms:true
    virtual-host:/  
```
## 3.各种情景再现
### 1、最简单的hello生产和消费实现（单生产者和单消费者）

生产者：
```
package ins.platform.rabbit.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}

```
消费者：
```
package ins.platform.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
```

配置文档：
```
package ins.platform.rabbit.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class HelloConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

}
```

controller：
```
package com.rabbit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.hello.HelloSender1;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;
    
    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}

```
启动程序，执行：
![](http://git.jsptz.com/cloud/pictures/raw/master/hello.png)

结果如下：
Sender1 : hello1 Thu May 11 17:23:31 CST 2017

Receiver1  : hello1 Thu May 11 17:23:31 CST 2017

### 2、单生产者-多消费者

生产者：
```
package ins.platform.rabbit.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}
```
消费者1：
```
package ins.platform.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
```
消费者2：
```
package ins.platform.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
```
配置文档：

```
package ins.platform.rabbit.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class HelloConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

}

```

controller:

```
package ins.platform.rabbit.hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.hello.HelloSender1;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;
    
    @PostMapping("/hello")
    public void hello() {
        helloSender1.send("hello1");
    }
    
    /**
     * 单生产者-多消费者
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
        }
        
    }
}
```
用post方式执行：

http://localhost:18020/rabbit/oneToMany

结果如下：
```
Sender1 : hellomsg:0Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:1Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:2Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:3Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:4Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:5Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:6Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:7Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:8Fri Jun 08 16:40:39 CST 2018
Sender1 : hellomsg:9Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:0Fri Jun 08 16:40:39 CST 2018
Receiver2  : hellomsg:1Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:2Fri Jun 08 16:40:39 CST 2018
Receiver2  : hellomsg:3Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:4Fri Jun 08 16:40:39 CST 2018
Receiver2  : hellomsg:5Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:6Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:8Fri Jun 08 16:40:39 CST 2018
Receiver2  : hellomsg:7Fri Jun 08 16:40:39 CST 2018
Receiver1  : hellomsg:9Fri Jun 08 16:40:39 CST 2018
```
从以上结果可知，生产者发送的10条消息，分别被两个消费者接收了

### 3、多生产者-多消费者

生产者1：

```
package ins.platform.rabbit.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}

```
生产者2：

```
package ins.platform.rabbit.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender2 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}

```
消费者1：

```
package ins.platform.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
```
消费者2：
```
package ins.platform.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
```

配置文档：
```
package ins.platform.rabbit.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class HelloConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

}

```
controller:

```
    /**
     * 多生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
            helloSender2.send("hellomsg:"+i);
        }
        
    }
 ```

用post方式执行：

http://localhost:18020/rabbit/manyToMany


结果如下：
```
Sender1 : hellomsg:0Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:0Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:1Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:1Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:2Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:2Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:3Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:3Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:4Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:4Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:5Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:5Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:6Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:6Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:7Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:7Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:8Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:8Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:9Fri Jun 08 16:48:15 CST 2018
Sender1 : hellomsg:9Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:0Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:0Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:1Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:1Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:2Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:2Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:3Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:3Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:4Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:4Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:5Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:5Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:6Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:6Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:7Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:7Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:8Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:8Fri Jun 08 16:48:15 CST 2018
Receiver2  : hellomsg:9Fri Jun 08 16:48:15 CST 2018
Receiver1  : hellomsg:9Fri Jun 08 16:48:15 CST 2018
```
和一对多一样，接收端仍然会均匀接收到消息

### 4、实体类传输

springboot完美的支持对象的发送和接收，不需要格外的配置。

实体类（必须实现序列化接口）：

```
package ins.platform.rabbit.user;

import java.io.Serializable;

public class User implements Serializable{
        private String name;
        private String pass;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPass() {
            return pass;
        }
        public void setPass(String pass) {
            this.pass = pass;
        }
}
``` 

生产者：

```
package ins.platform.rabbit.user;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }

}

```
消费者：

```
package ins.platform.rabbit.user;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }

}

```
配置文档：

```
package ins.platform.rabbit.user;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
	
	@Bean
    public Queue userQueue() {
        return new Queue("userQueue");
    }

}

```
controller:

```
package ins.platform.rabbit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserSender userSender;
	
	@PostMapping("/userTest")
    public void userTest() {
           userSender.send();
    }

}

  
 ```
用post方式执行：

http://localhost:18020/user/userTest

结果如下：

user send : hzb/123456789   
user receive  : hzb/123456789

### 5、topic ExChange示例

topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
首先对topic规则配置，这里使用两个队列来测试（也就是在Application类中创建和绑定的topic.message和topic.messages两个队列），其中topic.message的bindting_key为 “topic.message”，topic.messages的binding_key为“topic.#”；

生产者：
```

package ins.platform.rabbit.topic;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);
        
        String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}
```

消费者1（topic.message）

```
package ins.platform.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }

}
```
消费者２（topic.messages）

```
package ins.platform.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class topicMessagesReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessagesReceiver  : " +msg);
    }

}
```

配置文档：
```
package ins.platform.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
```
controller:

```
package ins.platform.rabbit.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/topic")
public class TopicController {
    
	 @Autowired
	   private TopicSender topicSender;
    
	 @PostMapping("/test")
	    public void topicTest() {
	           topicSender.send();
	    }
    
    
}
```

用post方式执行：

http://localhost:18020/topic/test

结果如下：

sender1 : I am topic.mesaage msg======   
sender2 : I am topic.mesaages msg########    
topicMessageReceiver  : I am topic.mesaage msg======    
topicMessagesReceiver  : I am topic.mesaage msg======          
topicMessagesReceiver  : I am topic.mesaages msg########       

由以上结果可知：       
sender1发送的消息,routing_key是“topic.message”，所以exchange里面的绑定的binding_key是“topic.message”，topic.＃都符合路由规则;所以sender1发送的消息，两个队列都能接收到；           
sender2发送的消息，routing_key是“topic.messages”，所以exchange里面的绑定的binding_key只有topic.＃都符合路由规则;所以sender2发送的消息只有队列topic.messages能收到。

### 6、fanout ExChange示例

Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。

这里使用三个队列来测试（也就是在Application类中创建和绑定的fanout.A、fanout.B、fanout.C）这三个队列都和Application中创建的fanoutExchange转发器绑定。

生产者：

```
package ins.platform.rabbit.fanout;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }

}
```
消费者A:

```
package ins.platform.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }

}
```
消费者Ｂ：

```
package ins.platform.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

}
```
消费者C:

```
package ins.platform.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }

}
```
配置文件：
```
package ins.platform.rabbit.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
	
	@Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    
    
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}

```
controller:

```
 package ins.platform.rabbit.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
public class FanoutController {
	
	 @Autowired
	 private FanoutSender fanoutSender;
	
	 @PostMapping("/fanoutTest")
	    public void fanoutTest() {
	           fanoutSender.send();
	    }

}

```
用post方式执行：

http://localhost:18020/fanout/fanoutTest

结果如下：   
fanoutSender :hello i am hzb                  
FanoutReceiverC  : fanoutSender :hello i am hzb                    
FanoutReceiverB  : fanoutSender :hello i am hzb        
FanoutReceiverA  : fanoutSender :hello i am hzb        
由以上结果可知：就算fanoutSender发送消息的时候，指定了routing_key为"abcd.ee"，但是所有接收者都接受到了消息       

 