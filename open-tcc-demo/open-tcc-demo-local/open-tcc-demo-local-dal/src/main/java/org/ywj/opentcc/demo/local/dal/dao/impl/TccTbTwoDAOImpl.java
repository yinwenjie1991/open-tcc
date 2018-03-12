package org.ywj.opentcc.demo.local.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ywj.opentcc.demo.local.dal.dao.TccTbTwoDAO;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwo;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwoExample;
import org.ywj.opentcc.demo.local.dal.mapper.dbtwo.auto.TccTbTwoMapper;

import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-12
 */
@Repository("tccTbTwoDAO")
public class TccTbTwoDAOImpl implements TccTbTwoDAO {

    @Autowired
    private TccTbTwoMapper tccTbTwoMapper;

    @Override
    public List<TccTbTwo> selectAll() {
        TccTbTwoExample example = new TccTbTwoExample();
        return tccTbTwoMapper.selectByExample(example);
    }
}
