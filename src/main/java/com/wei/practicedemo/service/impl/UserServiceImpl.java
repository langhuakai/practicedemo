package com.wei.practicedemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.dao.UserMapper;
import com.wei.practicedemo.entity.UserEntity;
import com.wei.practicedemo.middleentity.Address;
import com.wei.practicedemo.middleentity.QueryEntity;
import com.wei.practicedemo.service.UserService;
import com.wei.practicedemo.vo.UserVO;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据userVO查询用户
     * @param queryEntity
     * @return
     */
    @Override
    public List<UserVO> queryUsers(QueryEntity queryEntity) {
        List<UserEntity> userEntities = userMapper.queryUsers(translateQuery2UserEntity(queryEntity));
        List<UserVO> userVOList = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            UserVO returnUserVO = translateEntity2VO(userEntity);
            userVOList.add(returnUserVO);
        }
        return userVOList;
    }

    /**
     * 插入用户
     * @param userVO
     */
    @Override
    public void insertUser(UserVO userVO) {
        userMapper.insertUser(translateVO2Entity(userVO));
    }

    /**
     * 更新用户
     * @param userVO
     */
    @Override
    public void updateUser(UserVO userVO) {
        userMapper.updateUser(translateVO2Entity(userVO));
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void delete(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public PageInfo<UserVO> findAllUserByPageF(int pageNum, int pageSize, UserVO userVO) {
        // TODO Auto-generated method stub
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> lists = userMapper.queryUsers(translateVO2Entity(userVO));
        List<UserVO> userVOList = new ArrayList<>();
        for (UserEntity userEntity : lists) {
            UserVO returnUserVO = translateEntity2VO(userEntity);
            userVOList.add(returnUserVO);
        }
        PageInfo<UserVO> pageInfo = new PageInfo<UserVO>(userVOList);
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    @Override
    public PageInfo<UserVO> findAllUserByPageS(int pageNum, int pageSize, UserVO userVO) {
        // TODO Auto-generated method stub
        List<UserEntity> lists = userMapper.queryUsers(translateVO2Entity(userVO));
        List<UserVO> userVOList = new ArrayList<>();
        for (UserEntity userEntity : lists) {
            UserVO returnUserVO = translateEntity2VO(userEntity);
            userVOList.add(returnUserVO);
        }
        PageInfo<UserVO> pageInfo = new PageInfo<UserVO>(userVOList);
        return pageInfo;

    }

    /**
     * 将UserVO转换为UserEntity
     * @param userVO
     * @return
     */
    public UserEntity translateVO2Entity(UserVO userVO) {
        if (null == userVO) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userVO.getId());
        userEntity.setUserName(userVO.getUserName());
        userEntity.setAge(userVO.getAge());
        userEntity.setEmail(userVO.getEmail());
        userEntity.setSex(userVO.getSex());
        userEntity.setEntryDate(userVO.getEntryDate());
        userEntity.setPhone(userVO.getPhone());
        if (userVO.getCompanyAddress() != null) {
            String companyAddress = userVO.getCompanyAddress().getProvince() + "," +userVO.getCompanyAddress().getCity() + "," + userVO.getCompanyAddress().getOrigin();
            userEntity.setCompanyAddress(companyAddress);
        }
        if (userVO.getPersonalPlans() != null && userVO.getPersonalPlans().length >0) {
            StringBuffer buffer = new StringBuffer();
            for (String plan : userVO.getPersonalPlans()) {
                buffer.append(plan + ",");
            }
            userEntity.setPersonalPlan(buffer.toString());
        }

        return userEntity;
    }

    /**
     * 将UserEntity转换为UserVO
     * @param userEntity
     * @return
     */
    public UserVO translateEntity2VO(UserEntity userEntity) {
        if (null == userEntity) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userEntity.getId());
        userVO.setUserName(userEntity.getUserName());
        userVO.setAge(userEntity.getAge());
        userVO.setEmail(userEntity.getEmail());
        userVO.setSex(userEntity.getSex());
        userVO.setEntryDate(userEntity.getEntryDate());
        userVO.setPhone(userEntity.getPhone());
        if (StringUtils.isNotEmpty(userEntity.getCompanyAddress())) {
            List<String> companyAddresss = Arrays.asList(
                    userEntity.getCompanyAddress().split(",")) ;
            Address companyAddress = new Address();
            companyAddress.setProvince(companyAddresss.get(0));
            companyAddress.setCity(companyAddresss.get(1));
            companyAddress.setOrigin(companyAddresss.get(2));
            userVO.setCompanyAddress(companyAddress);
        };
        if (!StringUtils.isEmpty(userEntity.getPersonalPlan())) {
            String[] personalPlans = userEntity.getPersonalPlan().split(",") ;
            userVO.setPersonalPlans(personalPlans);
        }
        return userVO;
    }

    /**
     * 将QueryEntity转化为UserEntity
     * @param queryEntity
     * @return
     */
    public UserEntity translateQuery2UserEntity(QueryEntity queryEntity) {
        if (null == queryEntity) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(queryEntity.getUserName());
        userEntity.setEntryDate(queryEntity.getEntryDate());
        userEntity.setPersonalPlan(queryEntity.getPersonalPlans());
        if (StringUtils.isNotEmpty(queryEntity.getProvince())
                && StringUtils.isNotEmpty(queryEntity.getCity())
                && StringUtils.isNotEmpty(queryEntity.getOrigin())) {
            String str = queryEntity.getProvince() + queryEntity.getCity() + queryEntity.getOrigin();
            userEntity.setCompanyAddress(str);
        }
        return userEntity;
    }
}
