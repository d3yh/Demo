package com.dyh.controller;

import com.alibaba.fastjson.JSON;
import com.dyh.entity.User;
import com.dyh.kafkaDemo.KfkaProducer;
import com.dyh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date 2019/12/3 11:13
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private KfkaProducer kfkaProducer;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @RequestMapping("/toAdd")
    public String toAdd(){

        return "add";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    private String addUser(User user){
        kfkaProducer.send("user",JSON.toJSONString(user));
//        ListenableFuture future = kafkaTemplate.send("user", JSON.toJSONString(user));
//        future.addCallback(new SuccessCallback() {
//            @Override
//            public void onSuccess(Object o) {
//                System.out.println("发送消息成功");
//            }
//        }, new FailureCallback() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                System.out.println("添加失败");
//            }
//        });
        //int result = userService.addUserByUsername(user);
        //System.out.println(result);
        //redisTemplate.opsForValue().set(user.getUserName(),"111");
        return "成功";
    }

    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg(){

        kfkaProducer.send("hello","heihei");
        return "success";
    }


}
