package com.dyh.kafkaDemo;

import com.alibaba.fastjson.JSON;
import com.dyh.entity.User;
import com.dyh.service.IUserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Date 2019/12/9 19:03
 * @Author 丁宇辉
 */
@Component
public class KafkaConsumer {

    @Autowired
    private IUserService userService;

    @KafkaListener(topics = {"user"})
    public void listen(ConsumerRecord record){
        Optional kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()){
            String user = (String) kafkaMessage.get();
            //转换为user对象
            User user1 = JSON.parseObject(user, User.class);
            //进行数据库操作
            userService.addUserByUsername(user1);

            System.out.println("消费者2：接受到的消息-----------" + user  );
        }

    }


    @KafkaListener(topics = {"hello"},groupId = "test1")
    public void listen2(ConsumerRecord record){
        Optional kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()){
            Object user = kafkaMessage.get();
            System.out.println("消费者1：接受到的消息-----------" + user  );
        }

    }
}
