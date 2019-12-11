package com.dyh.task;

import com.dyh.entity.Uv;
import com.dyh.service.IUVService;
import com.dyh.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Date 2019/12/5 19:16
 * @Author 丁宇辉
 */
@Component
public class DataEntryTime {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IUVService uvService;

    /**
     * 设置定时器，每天0点01分的时候，将前一天的访问量存入数据库
     */
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void DataEntry(){
        System.out.println("定时器启动了");
        //获得前后一天的时间
        String dateSCore = TimeUtil.beforeTime(-1);
        String UVKey = "UVCount_"+dateSCore;


        //获得对应时间访问量
        //Long size = redisTemplate.opsForHash().size(UVKey);
        Long size = redisTemplate.opsForSet().size(UVKey);
        System.out.println("当前点击量为：" + size);

        //获得截至到前一天的点击量总和
        Long nowCount = Long.parseLong("0");
        String dataScore_2 = TimeUtil.beforeTime(-2);
        //查询数据库最新的点击总量
        Uv uv2 = uvService.queryNowCountByTime(dataScore_2);
        if (uv2 != null){
            nowCount = uv2.getNowcount();
            System.out.println("之前总和为" + nowCount);
        }


        //存入数据库
        Uv uv = new Uv();
        uv.setClick(size);
        uv.setClocktime(dateSCore);
        uv.setNowcount(nowCount + size);

        uvService.insertClick(uv);

    }

}
