package com.wei.practicedemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.dao.UserMapper;
import com.wei.practicedemo.service.UserService;
import com.wei.practicedemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserVO> queryUsers(UserVO userVO) {
        return userMapper.queryUsers(userVO);
    }

    @Override
    public void insertUser(UserVO userVO) {
        userMapper.insertUser(userVO);
    }

    @Override
    public void updateUser(UserVO userVO) {
        userMapper.updateUser(userVO);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public List<UserVO> findAllUserByPageF(UserVO userVO, int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<UserVO> lists = userMapper.queryUsers(userVO);
        return lists;
    }

    @Override
    public PageInfo<UserVO> findAllUserByPageS(UserVO userVO, int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<UserVO> lists = userMapper.queryUsers(userVO);
        PageInfo<UserVO> pageInfo = new PageInfo<UserVO>(lists);
        return pageInfo;

    }
}
