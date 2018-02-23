package org.ywj.opentcc.api;

import java.io.Serializable;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class TransactionContext implements Serializable{

    private static final long serialVersionUID = 495387621447307264L;

    private String groupTrxId;

    private String branchTrxId;

    private byte status;

    public TransactionContext(String groupTrxId, String branchTrxId, byte status) {
        this.groupTrxId = groupTrxId;
        this.branchTrxId = branchTrxId;
        this.status = status;
    }

    public String getGroupTrxId() {
        return groupTrxId;
    }

    public String getBranchTrxId() {
        return branchTrxId;
    }

    public byte getStatus() {
        return status;
    }

    public void setGroupTrxId(String groupTrxId) {
        this.groupTrxId = groupTrxId;
    }

    public void setBranchTrxId(String branchTrxId) {
        this.branchTrxId = branchTrxId;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
