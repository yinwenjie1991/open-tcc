package org.ywj.opentcc.api;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public enum TransactionStatus {
    TRYING((byte)1), CONFIRMING((byte)2), CANCELLING((byte)3);

    private byte status;

    TransactionStatus(byte status) {
        this.status = status;
    }

    public byte getStatus() {
        return status;
    }

    public static TransactionStatus valueOf(byte status) {
        switch (status) {
            case 1:
                return TRYING;
            case 2:
                return CONFIRMING;
            default:
                return CANCELLING;
        }
    }
}
