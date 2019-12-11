package com.dyh.service;

import com.dyh.entity.GoodsInfo;

public interface IGoodsService {
    int reduceStocks(Integer gid);

    GoodsInfo queryById(Integer gid);
}
