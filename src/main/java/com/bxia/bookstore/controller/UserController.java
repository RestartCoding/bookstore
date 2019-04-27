package com.bxia.bookstore.controller;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.service.UserService;
import com.bxia.bookstore.web.CommonResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Valid
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param user 用户
     * @return 用户信息
     */
    @PostMapping("/login")
    public CommonResponse login(@RequestBody User user){
        User result = userService.login(user.getUsername(), user.getPassword());
        return CommonResponse.ok(result);
    }
    @PostMapping("/register")
    public CommonResponse register(User user){
        return CommonResponse.ok(userService.register(user));
    }

    @GetMapping("/{id}")
    public CommonResponse getUserInfo(@PathVariable int id){
        return CommonResponse.ok(userService.getUserInfo(id));
    }

    @PutMapping
    public CommonResponse updateUserInfo(@RequestBody User user){
        boolean success = userService.updateUserInfo(user);
        if (success){
            return CommonResponse.ok("修改用户信息成功");
        }
        return CommonResponse.error("修改用户信息失败");
    }

    @DeleteMapping("/{id}")
    public CommonResponse deleteUser(@PathVariable int id){
        boolean success = userService.deleteUser(id);
        if (success){
            return CommonResponse.ok("删除用户信息成功");
        }
        return CommonResponse.error("删除用户信息失败");
    }
}