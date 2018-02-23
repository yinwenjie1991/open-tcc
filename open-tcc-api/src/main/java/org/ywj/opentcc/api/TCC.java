package org.ywj.opentcc.api;

import org.ywj.opentcc.common.util.StringUtil;

import java.lang.annotation.*;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TCC {

    Propagation propagation() default Propagation.REQUIRED;

    String confirm() default StringUtil.EMPTY_STRING;

    String cancle() default StringUtil.EMPTY_STRING;

    boolean asyncConfirm() default false;

    boolean asyncCancel() default false;
}
