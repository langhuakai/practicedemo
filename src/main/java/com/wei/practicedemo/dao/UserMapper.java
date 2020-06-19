package com.wei.practicedemo.dao;

import com.wei.practicedemo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> queryUsers(UserVO userVO);

    void updateUser(UserVO userVO);

    void insertUser(UserVO userVO);

    void deleteUser(int id);

    List<UserVO> queryUserInfo();
}
