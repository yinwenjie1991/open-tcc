package org.ywj.opentcc.demo.local.dal.entity;

public class TccTbOne {
    private Integer t1Id;

    private String uniqNo;

    private Byte status;

    public Integer getT1Id() {
        return t1Id;
    }

    public void setT1Id(Integer t1Id) {
        this.t1Id = t1Id;
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