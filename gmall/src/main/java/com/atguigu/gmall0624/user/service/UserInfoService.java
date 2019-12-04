package com.atguigu.gmall0624.user.service;

import com.atguigu.gmall0624.user.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 返回所有数据
     * @return
     */
    List<UserInfo>  findAll();

    //根据用户id，或者用户的昵称或者根据用户的名称等多个不同的字段进行查询，如果什么都不输入，则查询所有
    List<UserInfo> findUserInfo(UserInfo userInfo);

    //模糊查询 nickName
    List<UserInfo> findByNickName(String nickName);

    //添加
    void addUser(UserInfo userInfo);

    //修改
    void updUser(UserInfo userInfo);

    //删除
    void delUser(UserInfo userInfo);

}
