package com.wei.practicedemo.controller;

import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.entity.UserEntity;
import com.wei.practicedemo.exception.GlobalException;
import com.wei.practicedemo.handler.Result;
import com.wei.practicedemo.middleentity.QueryEntity;
import com.wei.practicedemo.service.UserService;
import com.wei.practicedemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryUsers")
    public Result queryUsers(QueryEntity queryEntity) {

        List<UserVO> userVOList =  userService.queryUsers(queryEntity);
        if (userVOList == null || userVOList.size() == 0) {
            throw new GlobalException("未查询到结果，请确认输入是否正确");
        }
        return Result.ok().data("users", userVOList).message("查询成功");
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody UserVO userVO) {
        userService.updateUser(userVO);
        return Result.ok().message("更新用户成功");

    }

    @PutMapping("/insertUser")
    public Result insertUser(@RequestBody UserVO userVO, HttpServletRequest request) {
        userService.insertUser(userVO);
        return Result.ok().message("插入用户成功");
    }

    @DeleteMapping("/deleteUser")
    public Result deleteUser(@RequestParam int id) {
        userService.delete(id);
        return Result.ok().message("删除用户成功");
    }

    @GetMapping("/testPageHelper1")
    public Result testPageHelper1(int pageNum, int pageSize, @ModelAttribute("userVO")UserVO userVO){
        PageInfo<UserVO> queryResult = userService.findAllUserByPageS(pageNum, pageSize, userVO);
        return Result.ok().data("pageInfo", queryResult);
    }

    @GetMapping("/testPageHelper2")
    public Result testPageHelper2(int pageNum, int pageSize, @ModelAttribute("userVO")UserVO userVO){
        PageInfo<UserVO> queryResult = userService.findAllUserByPageF(pageNum, pageSize, userVO);
        return Result.ok().data("pageInfo", queryResult);
    }


}
