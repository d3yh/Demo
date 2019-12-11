package com.dyh.service;

import com.dyh.entity.Uv;

public interface IUVService {

    int insertClick(Uv uv);

    Uv queryNowCountByTime(String dateSCore);
}
