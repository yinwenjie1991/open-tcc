package org.ywj.opentcc.core.model;

import org.ywj.opentcc.api.TransactionContext;
import org.ywj.opentcc.api.TransactionStatus;
import org.ywj.opentcc.common.util.UUIDUtils;
import org.ywj.opentcc.core.enums.TrxType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class Transaction implements Serializable{

    private static final long serialVersionUID = -7091667287066999809L;

    private Long id;

    private String region;

    private String groupTrxId;

    private String branchTrxId;

    private Byte status;

    private Byte trxType;

    private Integer retryTimes = 0;

    private Integer version = 1;

    private Date gmtCreate = new Date();

    private Date gmtModified = new Date();

//    private byte[] content;

    private List<Performer> performers = new ArrayList<Performer>();

    public Transaction(TrxType trxType) {
        this.groupTrxId = UUIDUtils.uuid();
        this.branchTrxId = UUIDUtils.uuid();
        this.status = TransactionStatus.TRYING.getStatus();
        this.trxType = trxType.getId();
    }

    public Transaction(TransactionContext transactionContext) {
        this.groupTrxId = transactionContext.getGroupTrxId();
        this.branchTrxId = transactionContext.getBranchTrxId();
        this.status = TransactionStatus.TRYING.getStatus();
        this.trxType = TrxType.BRANCH.getId();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getGroupTrxId() {
        return groupTrxId;
    }

    public String getBranchTrxId() {
        return branchTrxId;
    }

    public Byte getStatus() {
        return status;
    }

    public Byte getTrxType() {
        return trxType;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public Integer getVersion() {
        return version;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

//    public byte[] getContent() {
//        return content;
//    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGroupTrxId(String groupTrxId) {
        this.groupTrxId = groupTrxId;
    }

    public void setBranchTrxId(String branchTrxId) {
        this.branchTrxId = branchTrxId;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public void setTrxType(Byte trxType) {
        this.trxType = trxType;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

//    public void setContent(byte[] content) {
//        this.content = content;
//    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public void addPerformers(Performer performer) {
        this.performers.add(performer);
    }

    public void versionAdd() {
        this.version++;
    }

    public void rollback() {

        for (Performer performer : performers) {
            performer.rollback();
        }

    }

    public void commit() {

        for (Performer performer : performers) {
            performer.commit();
        }

    }


}
