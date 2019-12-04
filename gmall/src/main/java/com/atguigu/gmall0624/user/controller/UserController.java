package com.atguigu.gmall0624.user.controller;

import com.atguigu.gmall0624.user.bean.UserInfo;
import com.atguigu.gmall0624.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }
    //springmvc对象传值
    //localhost:8080/findByUserInfo?id=
    //localhost:8080/findByUserInfo?name=
    //localhost:8080/findByUserInfo?id=xxx&name=xxx
    @RequestMapping("findByUserInfo")
    public List<UserInfo> findByUserInfo(UserInfo userInfo){
        return userInfoService.findUserInfo(userInfo);
    }

    //localhost:8080/findByNickName?nickName=
    @RequestMapping("findByNickName")
    public List<UserInfo> findByNickName(String nickName){
        return userInfoService.findByNickName(nickName);
    }

    //localhost:8080/addUser?name=xxx&nickName=xxx
    @RequestMapping("addUser")
    public void addUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
    }

    //localhost:8080/updUser?nickName=madaha&loginName=hhh
    @RequestMapping("updUser")
    public void updUser(UserInfo userInfo){
        userInfoService.updUser(userInfo);
    }

    //localhost:8080/delUser?id=
    @RequestMapping("delUser")
    public void delUser(UserInfo userInfo){
        userInfoService.delUser(userInfo);

    }

}
