package com.dyh.service.impl;

import com.dyh.dao.GoodsMapper;
import com.dyh.entity.GoodsInfo;
import com.dyh.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date 2019/12/4 13:17
 * @Author 丁宇辉
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 减少库存
     * @param gid
     * @return
     */
    @Override
    public int reduceStocks(Integer gid) {
        GoodsInfo goodsInfo = queryById(gid);
        goodsInfo.setStock(goodsInfo.getStock() - 1);
        return goodsMapper.updateById(goodsInfo);
}

    @Override
    public GoodsInfo queryById(Integer gid) {
        GoodsInfo goodsInfo = goodsMapper.selectById(gid);
        return goodsInfo;
    }
}
