package com.dyh.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dyh.entity.User;


public interface IUserService extends IService<User>  {

    public int addUserByUsername(User user);

}
