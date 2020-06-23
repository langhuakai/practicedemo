package com.wei.practicedemo.controller;

import com.github.pagehelper.PageInfo;
import com.wei.practicedemo.entity.UserEntity;
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
    public List<UserVO> queryUsers(QueryEntity queryEntity) {

        return userService.queryUsers(queryEntity);
    }

    // 数组
  /*  @GetMapping("/queryUsers2")
    public List<UserVO> queryUsers(String[] personalPlans) {

        UserVO userVO = new UserVO();
        userVO.setPersonalPlans(personalPlans);
        return userService.queryUsers(userVO);
    }
*/
    // 字符串
    @GetMapping("/queryUsers3")
    public List<UserVO> queryUsers(@RequestParam String personalPlans) {
        // return queryService.queryUsers();

       /* List<UserVO> users = new ArrayList<>();
        UserVO userVO = new UserVO(2,"wei","男",22,"aaa@qq.com","13322222222","技术型","2020-02-22","广东省，深圳市，南山区");
        users.add(userVO);
        return users2;*/

        QueryEntity queryEntity = new QueryEntity();
        return userService.queryUsers(queryEntity);
    }

    // List
    @GetMapping("/queryUsers4")
    public List<UserVO> queryUsers(@RequestBody List<String> personalPlans) {

        QueryEntity queryEntity = new QueryEntity();
        //userVO.setPersonalPlans(personalPlans);
        return userService.queryUsers(queryEntity);
    }

    @PostMapping("/updateUser")
    public void updateUser(@ModelAttribute("userVO")UserVO userVO) {
        userService.updateUser(userVO);

    }

    @PutMapping("/insertUser")
    public void insertUser(@RequestBody UserVO userVO, HttpServletRequest request) {
        userService.insertUser(userVO);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam int id) {
        userService.delete(id);
    }

    @GetMapping("/testPageHelper1")
    public PageInfo<UserVO> testPageHelper1(int pageNum, int pageSize, @ModelAttribute("userVO")UserVO userVO){
        PageInfo<UserVO> queryResult = userService.findAllUserByPageS(pageNum, pageSize, userVO);
        return queryResult;
    }

    @GetMapping("/testPageHelper2")
    public PageInfo<UserVO> testPageHelper2(int pageNum, int pageSize, @ModelAttribute("userVO")UserVO userVO){
        PageInfo<UserVO> queryResult = userService.findAllUserByPageF(pageNum, pageSize, userVO);
        return queryResult;
    }


}
