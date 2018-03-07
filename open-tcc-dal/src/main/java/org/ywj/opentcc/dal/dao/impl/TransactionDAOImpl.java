package org.ywj.opentcc.dal.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ywj.opentcc.common.exception.OptimitsticLockException;
import org.ywj.opentcc.dal.config.TccDBConfig;
import org.ywj.opentcc.dal.dao.TransactionDAO;
import org.ywj.opentcc.dal.entity.TccTrxDo;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Repository("transactionDAO")
public class TransactionDAOImpl extends SqlSessionDaoSupport implements TransactionDAO{

    @Resource(name = "tccSqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @Override
    @Resource(name = "tccSqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Autowired
    private TccDBConfig tccDBConfig;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(TccTrxDo tccTrxDo) {
//        tccTrxDo.setTccTbName(tccDBConfig.getTTCTB_NAME());
//        tccTrxDo.setRegion(tccDBConfig.getREGION());
        doConfig(tccTrxDo);
        return getSqlSession().insert("tccTrxManualMapper.insert", tccTrxDo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(TccTrxDo tccTrxDo) {
        doConfig(tccTrxDo);
        return getSqlSession().update("tccTrxManualMapper.update", tccTrxDo);
    }

    @Override
    public int OpstimisticLockUpdate(TccTrxDo tccTrxDo) {
        int result = 0;
        result = update(tccTrxDo);
        if (result <= 0) {
            //抛出乐观锁异常
            throw new OptimitsticLockException();
        }
        return result;
    }

    @Override
    public TccTrxDo findByTrxId(String groupTrxId, String branchTrxId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("groupTrxId", groupTrxId);
        map.put("branchTrxId", branchTrxId);
        doConfig(map);
        return getSqlSession().selectOne("selectByTrxId", map);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(String groupTrxId, String branchTrxId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("groupTrxId", groupTrxId);
        map.put("branchTrxId", branchTrxId);
        doConfig(map);
        return getSqlSession().delete("deleteByTrxId", map);
    }

    private void doConfig(TccTrxDo tccTrxDo) {
        tccTrxDo.setTccTbName(tccDBConfig.getTTCTB_NAME());
        tccTrxDo.setRegion(tccDBConfig.getREGION());
    }

    private void doConfig(Map map) {
        map.put("tccTbName", tccDBConfig.getTTCTB_NAME());
    }
}
