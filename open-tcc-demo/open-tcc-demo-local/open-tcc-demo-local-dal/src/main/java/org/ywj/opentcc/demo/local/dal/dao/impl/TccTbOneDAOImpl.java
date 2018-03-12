package org.ywj.opentcc.demo.local.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ywj.opentcc.demo.local.dal.dao.TccTbOneDAO;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOne;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOneExample;
import org.ywj.opentcc.demo.local.dal.mapper.dbone.auto.TccTbOneMapper;

import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-12
 */
@Repository("TccTbOneDAO")
public class TccTbOneDAOImpl implements TccTbOneDAO{

    @Autowired
    private TccTbOneMapper tccTbOneMapper;

    @Override
    public List<TccTbOne> selectAll() {
        TccTbOneExample example = new TccTbOneExample();
        return tccTbOneMapper.selectByExample(example);
    }
}
