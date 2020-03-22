package com.summer.validation.controller.request;

import com.summer.validation.controller.annotations.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: create by Summer.Xiong
 * @version: v1.0
 * @description:
 * @date: 2020/3/22 14:47
 */
@ApiModel(description = "用户请求处理类")
@Data
public class UserReq {

    @ApiModelProperty(value = "用户名称", required = true)
    @Max(value = 20)
    private long id;

    @ApiModelProperty(value = "用户名称")
    @NotNull(message = "姓名不能为Null")
    private String name;

    @ApiModelProperty(value = "用户身份证")
    @NotEmpty(message = "身份证号码不能为空")
    private String cardNum;

    @ApiModelProperty(value = "用户状态")
    @FlagValidator(value = {"0", "1", "2"}, message = "用户状态错误")
    private Integer status;

}
