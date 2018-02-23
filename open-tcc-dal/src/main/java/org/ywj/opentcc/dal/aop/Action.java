package org.ywj.opentcc.dal.aop;

import java.lang.annotation.*;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-02
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String value() default "";
}
