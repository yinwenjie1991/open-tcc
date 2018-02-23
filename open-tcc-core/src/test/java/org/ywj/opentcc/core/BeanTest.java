package org.ywj.opentcc.core;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.ywj.opentcc.core.enums.TrxType;
import org.ywj.opentcc.core.model.Transaction;
import org.ywj.opentcc.dal.entity.TccTrxDo;

import java.lang.reflect.InvocationTargetException;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-06
 */
public class BeanTest {

    @Test
    public void beanTest() throws InvocationTargetException, IllegalAccessException {
        Transaction transaction = new Transaction(TrxType.ROOT);
        TccTrxDo tccTrxDo = new TccTrxDo();
        BeanUtils.copyProperties(transaction, tccTrxDo);
        System.out.println("end");
    }
}
