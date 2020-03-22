package com.summer.validation.controller.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author: create by Summer.Xiong
 * @version: v1.0
 * @description:
 *
 *      自定义枚举值校验类
 *      例如实际项目中,用户存在状态属性, {0: 有效, 1: 失效, 2:锁定}
 *      而前端页面传递了枚举状态为3的值，因此需要校验传递的状态值是否有效
 *
 * @date: 2020/3/22 15:41
 */

//功能：指明修饰的注解，可以被例如javadoc此类的工具文档化，只负责标记，没有成员取值
@Documented

//指明修饰的注解的生存周期，即会保留到哪个阶段
@Retention(RetentionPolicy.RUNTIME)

//指明了修饰的这个注解的使用范围，即被描述的注解可以用在哪里
@Target({ElementType.FIELD, ElementType.PARAMETER})

//代表处理逻辑是FlagValidator类
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    String[] value() default {};

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
