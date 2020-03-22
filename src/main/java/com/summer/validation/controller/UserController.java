package com.summer.validation.controller;

import com.summer.validation.controller.request.UserReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: create by Summer.Xiong
 * @version: v1.0
 * @description:
 * @date: 2020/3/22 14:45
 */
@Api(tags = "UserController", value = "用户接口")
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @ApiOperation(value = "添加用户信息")
    @PostMapping("save")
    public void save(@RequestBody @Validated UserReq userReq, BindingResult bindingResult){


    }

}
