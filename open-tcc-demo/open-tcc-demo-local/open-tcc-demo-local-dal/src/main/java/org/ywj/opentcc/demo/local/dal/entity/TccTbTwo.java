package org.ywj.opentcc.demo.local.dal.entity;

public class TccTbTwo {
    private Integer t2Id;

    private String uniqNo;

    private Byte status;

    public Integer getT2Id() {
        return t2Id;
    }

    public void setT2Id(Integer t2Id) {
        this.t2Id = t2Id;
    }

    public String getUniqNo() {
        return uniqNo;
    }

    public void setUniqNo(String uniqNo) {
        this.uniqNo = uniqNo == null ? null : uniqNo.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}