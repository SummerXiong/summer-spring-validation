package com.summer.validation.controller.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: create by Summer.Xiong
 * @version: v1.0
 * @description:
 * @date: 2020/3/22 15:46
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {

    private String[] vaules;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.vaules = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = false;
        if(value == null){
            //当状态为空时使用默认值
            return true;
        }
        for(int i=0;i<this.vaules.length;i++){
            if(this.vaules[i].equals(String.valueOf(value))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

}
