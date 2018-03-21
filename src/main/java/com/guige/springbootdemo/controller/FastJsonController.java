package com.guige.springbootdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guige.springbootdemo.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
public class FastJsonController {
	@ApiOperation("获取用户信息")
    @RequestMapping("/test")
	@ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    //@CrossOrigin(origins="http://localhost:8088")
    @ResponseBody
    public User test() {
        User user = new User();
        
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setBirthday(new Date());
        // 模拟异常
        return user;
    }
}