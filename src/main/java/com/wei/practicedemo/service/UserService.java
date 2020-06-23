package com.wei.practicedemo.service;

import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.middleentity.QueryEntity;
import com.wei.practicedemo.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> queryUsers(QueryEntity queryEntity);
    void insertUser(UserVO userVO);
    void updateUser(UserVO userVO);
    void delete(int id);

    PageInfo<UserVO> findAllUserByPageF(int pageNum,int pageSize, UserVO userVO);

    PageInfo<UserVO> findAllUserByPageS(int pageNum, int pageSize, UserVO userVO);
}
