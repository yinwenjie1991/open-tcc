package org.ywj.opentcc.dal.entity;

import java.util.Date;

public class TccTrxDo {
    private Long id;

    private String region;

    private String groupTrxId;

    private String branchTrxId;

    private Byte status;

    private Byte trxType;

    private Integer retryTimes;

    private Integer version;

    private Date gmtCreate;

    private Date gmtModified;

    private byte[] content;

    private String tccTbName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getGroupTrxId() {
        return groupTrxId;
    }

    public void setGroupTrxId(String groupTrxId) {
        this.groupTrxId = groupTrxId == null ? null : groupTrxId.trim();
    }

    public String getBranchTrxId() {
        return branchTrxId;
    }

    public void setBranchTrxId(String branchTrxId) {
        this.branchTrxId = branchTrxId == null ? null : branchTrxId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getTrxType() {
        return trxType;
    }

    public void setTrxType(Byte trxType) {
        this.trxType = trxType;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getTccTbName() {
        return tccTbName;
    }

    public void setTccTbName(String tccTbName) {
        this.tccTbName = tccTbName;
    }
}