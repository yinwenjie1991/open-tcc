package org.ywj.opentcc.api;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public enum Propagation {
    REQUIRED(0),
    SUPPORTS(1),
    MANDATORY(2),
    REQUIRES_NEW(3);

    private final int value;

    Propagation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
