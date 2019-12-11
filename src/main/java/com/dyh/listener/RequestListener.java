package com.dyh.listener;

import com.dyh.util.RealIpUtil;
import com.dyh.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Date 2019/12/4 17:28
 * @Author 丁宇辉
 */
@WebListener
@Component
public class RequestListener implements ServletRequestListener {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    /**
     * 创建时执行
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        //得到当前访问用户的ip地址
        String realIp = (String) RealIpUtil.getRealIp(request);
        //获得当前日期的字符串
        String dateSCore = TimeUtil.dateSCore(new Date());

        String UVKey = "UVCount_"+dateSCore;

        //判断当前ip是否登录过
        redisTemplate.opsForSet().add(UVKey,realIp);

        Long size1 = redisTemplate.opsForSet().size(UVKey);
        System.out.println("当日访问量为"+size1);

        //判断当前ip是否登录过
        //Boolean isFirst = redisTemplate.opsForHash().hasKey(UVKey,realIp);

        //将ip存入set中
        //System.out.println("ip："+realIp);


        //System.out.println("当前ip是否访问过？"+isFirst);
//        if (!isFirst){
//            //访问量+1
//            //redisTemplate.opsForHash().increment("UVConut_"+dateSCore,realIp,1);
//            redisTemplate.opsForHash().put(UVKey,realIp,1+"");
//        }
//
//        //访问过的用户次数+1
//        redisTemplate.opsForHash().increment(UVKey,realIp,1);
//
//        //当时实时访问量
//        Long size = redisTemplate.opsForHash().size(UVKey);
//        System.out.println("当日访问量为：" + size);


        //System.out.println(realIp);
    }
}
