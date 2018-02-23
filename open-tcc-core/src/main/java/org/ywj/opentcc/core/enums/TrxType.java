package org.ywj.opentcc.core.enums;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-06
 */
public enum TrxType {
    ROOT((byte) 1),
    BRANCH((byte) 2);

    byte id;

    TrxType(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }
}
