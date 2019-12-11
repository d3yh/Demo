package com.dyh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyh.entity.Uv;
import org.apache.ibatis.annotations.Param;

public interface UVMapper extends BaseMapper<Uv> {
    Long queryNowCountByTime(@Param("dateScore") String dateSCore);
}
