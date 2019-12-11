package com.dyh.kafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * @Date 2019/12/9 12:03
 * @Author 丁宇辉
 */
@Component
public class KfkaProducer {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void  send(String topicName,Object data){

        ListenableFuture future = kafkaTemplate.send(topicName, data);
        future.addCallback(new SuccessCallback() {
            @Override
            public void onSuccess(Object o) {
                System.out.println("发送成功"+o);
            }

        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送异常"+throwable);
            }
        });

        System.out.println("发送消息------");

    }
}
