package com.dyh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Date 2019/12/5 19:54
 * @Author 丁宇辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uv implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;
    private Long click;
    private String clocktime;
    private Long nowcount;

}
