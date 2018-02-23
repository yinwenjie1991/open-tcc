package org.ywj.opentcc.dal.config;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-06
 */
public class TccDBConfig {

    private String REGION = "DEFAULT";

    private String TTC_TB_NAME = "TCC_TRX";

    public String getREGION() {
        return REGION;
    }

    public String getTTCTB_NAME() {
        return TTC_TB_NAME;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    public void setTTCTB_NAME(String TTCTB_NAME) {
        this.TTC_TB_NAME = TTCTB_NAME;
    }

}
