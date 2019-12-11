package com.dyh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Date 2019/12/4 13:12
 * @Author 丁宇辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    private Integer stock;
}



