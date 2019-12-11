package com.dyh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyh.entity.GoodsInfo;

public interface GoodsMapper extends BaseMapper<GoodsInfo> {

    int reduceStocks(Integer gid);
}
