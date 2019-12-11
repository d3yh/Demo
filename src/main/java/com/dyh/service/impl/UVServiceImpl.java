package com.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dyh.dao.UVMapper;
import com.dyh.entity.Uv;
import com.dyh.service.IUVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date 2019/12/5 19:52
 * @Author 丁宇辉
 */
@Service
public class UVServiceImpl implements IUVService {

    @Autowired
    private UVMapper uvMapper;

    @Override
    public int insertClick(Uv uv) {
        return uvMapper.insert(uv);
    }

    /**
     * 获得截至到前一天的点击量总和
     * @param dateSCore
     * @return
     */
    @Override
    public Uv queryNowCountByTime(String dateSCore) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("clocktime",dateSCore);
        Uv uv = uvMapper.selectOne(queryWrapper);

        return uv;
    }
}
