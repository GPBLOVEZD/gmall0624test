package com.atguigu.gmall0624.user.service.imp;

import com.atguigu.gmall0624.user.bean.UserInfo;
import com.atguigu.gmall0624.user.mapper.UserInfoMapper;
import com.atguigu.gmall0624.user.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
   //调用mapper

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    //根据用户id，或者用户的昵称或者根据用户的名称等
    @Override
    public List<UserInfo> findUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    //模糊查询 nickName
    @Override
    public List<UserInfo> findByNickName(String nickName) {

        //select * from user_info WHERE nick_name LIKE '%a%'
        //查询那张表就给那张表实体类
        Example example = new Example(UserInfo.class);
        //构造查询条件
        example.createCriteria().andLike("nickName","%"+nickName+"%");
        return userInfoMapper.selectByExample(example);
    }

    //添加
    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    //修改
    @Override
    public void updUser(UserInfo userInfo) {
        //按照用户的昵称nickName来修改loginName
        //update userInfo set loginName=? where nickName =?
        //第一个参数表示要修改的数据内容，第二个参数是跟什么修改：修改条件
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName",userInfo.getNickName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    //删除
    @Override
    public void delUser(UserInfo userInfo) {
        //长用！
        userInfoMapper.delete(userInfo);
    }
}
