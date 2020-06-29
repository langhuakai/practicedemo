package com.wei.practicedemo.controller;

import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.entity.UserEntity;
import com.wei.practicedemo.exception.GlobalException;
import com.wei.practicedemo.handler.Result;
import com.wei.practicedemo.middleentity.QueryEntity;
import com.wei.practicedemo.service.UserService;
import com.wei.practicedemo.util.ExceptionUtil;
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

        List<UserVO> userVOList;
        try{
            userVOList =  userService.queryUsers(queryEntity);
        } catch (Exception e) {
            throw new GlobalException("查询用户数据异常", 400);
        }
        return Result.ok().data("users", userVOList).message("查询用户成功");
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody UserVO userVO) {
        try {
            userService.updateUser(userVO);
        } catch (Exception e) {
            throw new GlobalException("更新用户异常", 400);
        }
        return Result.ok().message("更新用户成功");

    }

    @PutMapping("/insertUser")
    public Result insertUser(@RequestBody UserVO userVO, HttpServletRequest request) {
        try {
            userService.insertUser(userVO);
        } catch (Exception e) {
            throw new GlobalException("插入用户异常", 400);
        }
        return Result.ok().message("插入用户成功");
    }

    @DeleteMapping("/deleteUser")
    public Result deleteUser(@RequestParam int id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            throw new GlobalException("删除用户异常", 400);
        }
        return Result.ok().message("删除用户成功");
    }

    @GetMapping("/testPageHelper1")
    public Result testPageHelper1(int pageNum, int pageSize, @ModelAttribute("queryEntity")QueryEntity queryEntity){
        PageInfo<UserVO> queryResult;
        try {
            queryResult = userService.findAllUserByPageS(pageNum, pageSize, queryEntity);
        } catch (Exception e) {
            throw new GlobalException("分页查询异常", 400);
        }

        return Result.ok().data("pageInfo", queryResult);
    }

    @GetMapping("/testPageHelper2")
    public Result testPageHelper2(int pageNum, int pageSize, @ModelAttribute("queryEntity")QueryEntity queryEntity){
        PageInfo<UserVO> queryResult;
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queryResult = userService.findAllUserByPageF(pageNum, pageSize, queryEntity);
        } catch (Exception e) {
            throw new GlobalException("分页查询异常", 400);
        }
        return Result.ok().data("pageInfo", queryResult).message("查询用户成功");
    }

    /**
     * 测试内容
     * @param
     * @return
     */
    @GetMapping("/test")
    public Result test(){
        try{
            System.out.println(2/0);
        } catch(Exception e) {
            throw new GlobalException(ExceptionUtil.getMessage(e));
        }
        return Result.ok().data("pageInfo", "queryResult").message("查询用户成功");
    }


}
