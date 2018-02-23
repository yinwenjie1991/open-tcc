package org.ywj.opentcc.dal.dao;

import org.ywj.opentcc.dal.entity.TccTrxDo;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public interface TransactionDAO {

    int insert(TccTrxDo tccTrxDo);

    int update(TccTrxDo tccTrxDo);

    int OpstimisticLockUpdate(TccTrxDo tccTrxDo);

    TccTrxDo findByTrxId(String groupTrxId, String branchTrxId);

}
