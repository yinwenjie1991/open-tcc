package org.ywj.opentcc.demo.local.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class TccTbTwoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TccTbTwoExample() {
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

        public Criteria andT2IdIsNull() {
            addCriterion("t2_id is null");
            return (Criteria) this;
        }

        public Criteria andT2IdIsNotNull() {
            addCriterion("t2_id is not null");
            return (Criteria) this;
        }

        public Criteria andT2IdEqualTo(Integer value) {
            addCriterion("t2_id =", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdNotEqualTo(Integer value) {
            addCriterion("t2_id <>", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdGreaterThan(Integer value) {
            addCriterion("t2_id >", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t2_id >=", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdLessThan(Integer value) {
            addCriterion("t2_id <", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdLessThanOrEqualTo(Integer value) {
            addCriterion("t2_id <=", value, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdIn(List<Integer> values) {
            addCriterion("t2_id in", values, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdNotIn(List<Integer> values) {
            addCriterion("t2_id not in", values, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdBetween(Integer value1, Integer value2) {
            addCriterion("t2_id between", value1, value2, "t2Id");
            return (Criteria) this;
        }

        public Criteria andT2IdNotBetween(Integer value1, Integer value2) {
            addCriterion("t2_id not between", value1, value2, "t2Id");
            return (Criteria) this;
        }

        public Criteria andUniqNoIsNull() {
            addCriterion("uniq_no is null");
            return (Criteria) this;
        }

        public Criteria andUniqNoIsNotNull() {
            addCriterion("uniq_no is not null");
            return (Criteria) this;
        }

        public Criteria andUniqNoEqualTo(String value) {
            addCriterion("uniq_no =", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoNotEqualTo(String value) {
            addCriterion("uniq_no <>", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoGreaterThan(String value) {
            addCriterion("uniq_no >", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoGreaterThanOrEqualTo(String value) {
            addCriterion("uniq_no >=", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoLessThan(String value) {
            addCriterion("uniq_no <", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoLessThanOrEqualTo(String value) {
            addCriterion("uniq_no <=", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoLike(String value) {
            addCriterion("uniq_no like", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoNotLike(String value) {
            addCriterion("uniq_no not like", value, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoIn(List<String> values) {
            addCriterion("uniq_no in", values, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoNotIn(List<String> values) {
            addCriterion("uniq_no not in", values, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoBetween(String value1, String value2) {
            addCriterion("uniq_no between", value1, value2, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andUniqNoNotBetween(String value1, String value2) {
            addCriterion("uniq_no not between", value1, value2, "uniqNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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