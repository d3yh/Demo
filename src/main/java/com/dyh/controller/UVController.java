package com.dyh.controller;

import com.alibaba.fastjson.JSONObject;
import com.dyh.entity.Uv;
import com.dyh.service.IUVService;
import com.dyh.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Date 2019/12/4 17:04
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("/uv")
public class UVController {



    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IUVService uvService;


    @RequestMapping("/toUVList")
    @ResponseBody
    public String toUVList(Model model){

        JSONObject jsonObject = new JSONObject();

        //获得前一天的UVKey
        String dateSCore = TimeUtil.beforeTime(-1);
        String UVKey = "UVCount_"+dateSCore;

        //今日点击量
        String toDayDate = TimeUtil.dateSCore(new Date());
        String toDayUVKey = "UVCount_"+toDayDate;
        //Long toDay = redisTemplate.opsForHash().size(toDayUVKey);
        Long toDay = redisTemplate.opsForSet().size(toDayUVKey);
        System.out.println("今日点击量"+toDay);


        Uv uv = uvService.queryNowCountByTime(dateSCore);
        if (uv != null){
            //昨天点击量
            Long yseterDay = uv.getClick();
            System.out.println("昨日点击量"+yseterDay);

            //历史总点击量
            Long histroyClickCount = uv.getNowcount() + toDay;
            System.out.println("总点击量："+histroyClickCount);

            jsonObject.put("allClick",histroyClickCount);
            jsonObject.put("yesterDayClick",yseterDay);
        }


        jsonObject.put("toDayClick",toDay);
        String str = jsonObject.toString();


        return str;
    }
}
