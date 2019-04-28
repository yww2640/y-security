package com.slightlee.yadmin.annotation;

import java.lang.annotation.*;


/**
 * @description 系统日志注解
 *
 * @author SLIGHTLEE
 * @date 2019/4/26/26 18:22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";

}