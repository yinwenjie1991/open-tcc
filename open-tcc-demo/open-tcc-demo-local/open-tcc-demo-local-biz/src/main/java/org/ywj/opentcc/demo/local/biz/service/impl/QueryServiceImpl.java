package org.ywj.opentcc.demo.local.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ywj.opentcc.demo.local.biz.service.QueryService;
import org.ywj.opentcc.demo.local.dal.dao.TccTbOneDAO;
import org.ywj.opentcc.demo.local.dal.dao.TccTbTwoDAO;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOne;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwo;

import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-12
 */
@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    private TccTbOneDAO tccTbOneDAO;

//    @Autowired
//    private TccTbTwoDAO tccTbTwoDAO;

    @Override
    public List<TccTbOne> queryAllTccTbOne() {
        return tccTbOneDAO.selectAll();
    }

//    @Override
//    public List<TccTbTwo> queryAllTccTbTwo() {
//        return tccTbTwoDAO.selectAll();
//    }

}
