package org.ywj.opentcc.core.enums;

/**
 * 文件描述: 执行方法所属的事务类型
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public enum TransactionType {
    /**
     * ROOT: 代表执行根事务
     * BRANCH: 代表执行分支事务
     * REMOTE: 代表执行远程事务（在主事务中call分支事务）
     */
    ROOT(1),
    BRANCH(2),
    REMOTE(3);

    int value;

    TransactionType(int value) {
        this.value = value;
    }
}
