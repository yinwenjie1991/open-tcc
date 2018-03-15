package org.ywj.opentcc.demo.local.biz.service;

import org.ywj.opentcc.demo.local.dal.entity.TccTbOne;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwo;

import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-12
 */
public interface QueryService {

    List<TccTbOne> queryAllTccTbOne();

//    List<TccTbTwo> queryAllTccTbTwo();
}
