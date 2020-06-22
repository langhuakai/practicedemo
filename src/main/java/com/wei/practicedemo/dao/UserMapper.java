package com.wei.practicedemo.dao;

import com.wei.practicedemo.entity.UserEntity;
import com.wei.practicedemo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> queryUsers(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void insertUser(UserEntity userEntity);

    void deleteUser(int id);

    List<UserEntity> queryUserInfo();
}
