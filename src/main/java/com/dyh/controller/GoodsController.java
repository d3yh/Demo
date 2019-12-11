package com.dyh.controller;

import com.dyh.entity.GoodsInfo;
import com.dyh.service.IGoodsService;
import com.dyh.util.LockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 * @Date 2019/12/4 11:54
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private LockUtil lockUtil;


    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/buy")
    @ResponseBody
    @Transactional
    public String Buy(Integer gid,Integer uid){
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1000);

        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //加锁
                    boolean lock = lockUtil.lock(gid.toString(), 10000,1000,100);
                   // System.out.println("添加锁"+lock);
                    //判断是否上锁
                    if (lock){
                        //加锁成功，执行操作
                        int i1 = goodsService.reduceStocks(gid);

                        //释放锁
                        boolean unlock = lockUtil.unlock(gid.toString());
                        // System.out.println("释放锁"+unlock);

                    }
                    else {
                        //获得锁失败后?
                        System.out.println("失败");
                        //run();
                    }
                }
            });
        }

        GoodsInfo goodsInfo = goodsService.queryById(gid);

        return goodsInfo.getStock()+"";
    }

}
