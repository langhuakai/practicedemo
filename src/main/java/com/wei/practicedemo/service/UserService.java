package com.wei.practicedemo.service;

import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> queryUsers(UserVO userVO);
    void insertUser(UserVO userVO);
    void updateUser(UserVO userVO);
    void delete(int id);

    List<UserVO> findAllUserByPageF(UserVO userVO, int pageNum,int pageSize);

    PageInfo<UserVO> findAllUserByPageS(UserVO userVO, int pageNum, int pageSize);
}
