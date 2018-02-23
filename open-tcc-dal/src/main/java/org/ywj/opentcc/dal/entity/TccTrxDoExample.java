package org.ywj.opentcc.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TccTrxDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TccTrxDoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("REGION is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("REGION is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("REGION =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("REGION <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("REGION >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("REGION >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("REGION <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("REGION <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("REGION like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("REGION not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("REGION in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("REGION not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("REGION between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("REGION not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdIsNull() {
            addCriterion("GROUP_TRX_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdIsNotNull() {
            addCriterion("GROUP_TRX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdEqualTo(String value) {
            addCriterion("GROUP_TRX_ID =", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdNotEqualTo(String value) {
            addCriterion("GROUP_TRX_ID <>", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdGreaterThan(String value) {
            addCriterion("GROUP_TRX_ID >", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_TRX_ID >=", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdLessThan(String value) {
            addCriterion("GROUP_TRX_ID <", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_TRX_ID <=", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdLike(String value) {
            addCriterion("GROUP_TRX_ID like", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdNotLike(String value) {
            addCriterion("GROUP_TRX_ID not like", value, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdIn(List<String> values) {
            addCriterion("GROUP_TRX_ID in", values, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdNotIn(List<String> values) {
            addCriterion("GROUP_TRX_ID not in", values, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdBetween(String value1, String value2) {
            addCriterion("GROUP_TRX_ID between", value1, value2, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andGroupTrxIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_TRX_ID not between", value1, value2, "groupTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdIsNull() {
            addCriterion("BRANCH_TRX_ID is null");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdIsNotNull() {
            addCriterion("BRANCH_TRX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdEqualTo(String value) {
            addCriterion("BRANCH_TRX_ID =", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdNotEqualTo(String value) {
            addCriterion("BRANCH_TRX_ID <>", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdGreaterThan(String value) {
            addCriterion("BRANCH_TRX_ID >", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH_TRX_ID >=", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdLessThan(String value) {
            addCriterion("BRANCH_TRX_ID <", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdLessThanOrEqualTo(String value) {
            addCriterion("BRANCH_TRX_ID <=", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdLike(String value) {
            addCriterion("BRANCH_TRX_ID like", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdNotLike(String value) {
            addCriterion("BRANCH_TRX_ID not like", value, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdIn(List<String> values) {
            addCriterion("BRANCH_TRX_ID in", values, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdNotIn(List<String> values) {
            addCriterion("BRANCH_TRX_ID not in", values, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdBetween(String value1, String value2) {
            addCriterion("BRANCH_TRX_ID between", value1, value2, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andBranchTrxIdNotBetween(String value1, String value2) {
            addCriterion("BRANCH_TRX_ID not between", value1, value2, "branchTrxId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTrxTypeIsNull() {
            addCriterion("TRX_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTrxTypeIsNotNull() {
            addCriterion("TRX_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTrxTypeEqualTo(Byte value) {
            addCriterion("TRX_TYPE =", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeNotEqualTo(Byte value) {
            addCriterion("TRX_TYPE <>", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeGreaterThan(Byte value) {
            addCriterion("TRX_TYPE >", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("TRX_TYPE >=", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeLessThan(Byte value) {
            addCriterion("TRX_TYPE <", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeLessThanOrEqualTo(Byte value) {
            addCriterion("TRX_TYPE <=", value, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeIn(List<Byte> values) {
            addCriterion("TRX_TYPE in", values, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeNotIn(List<Byte> values) {
            addCriterion("TRX_TYPE not in", values, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeBetween(Byte value1, Byte value2) {
            addCriterion("TRX_TYPE between", value1, value2, "trxType");
            return (Criteria) this;
        }

        public Criteria andTrxTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("TRX_TYPE not between", value1, value2, "trxType");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNull() {
            addCriterion("RETRY_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNotNull() {
            addCriterion("RETRY_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesEqualTo(Integer value) {
            addCriterion("RETRY_TIMES =", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <>", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThan(Integer value) {
            addCriterion("RETRY_TIMES >", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES >=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThan(Integer value) {
            addCriterion("RETRY_TIMES <", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIn(List<Integer> values) {
            addCriterion("RETRY_TIMES in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotIn(List<Integer> values) {
            addCriterion("RETRY_TIMES not in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES not between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("GMT_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("GMT_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("GMT_CREATE =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("GMT_CREATE <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("GMT_CREATE >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("GMT_CREATE <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("GMT_CREATE in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("GMT_CREATE not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("GMT_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("GMT_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("GMT_MODIFIED =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("GMT_MODIFIED >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("GMT_MODIFIED <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("GMT_MODIFIED in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("GMT_MODIFIED not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}