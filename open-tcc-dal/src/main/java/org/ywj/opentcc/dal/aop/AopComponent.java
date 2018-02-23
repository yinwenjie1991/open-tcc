package org.ywj.opentcc.dal.aop;

import org.springframework.stereotype.Component;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-02
 */
@Component
public class AopComponent {

    @Action("print")
//    @ActionSecond("print")
    public void print() {
        System.out.println("aopcomponent execute");
    }
}
