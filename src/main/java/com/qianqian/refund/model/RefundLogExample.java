package com.qianqian.refund.model;

import com.framelib.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RefundLogExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andRefundTypeIsNull() {
            addCriterion("refund_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIsNotNull() {
            addCriterion("refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeEqualTo(Integer value) {
            addCriterion("refund_type =", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotEqualTo(Integer value) {
            addCriterion("refund_type <>", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThan(Integer value) {
            addCriterion("refund_type >", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_type >=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThan(Integer value) {
            addCriterion("refund_type <", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThanOrEqualTo(Integer value) {
            addCriterion("refund_type <=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIn(List<Integer> values) {
            addCriterion("refund_type in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotIn(List<Integer> values) {
            addCriterion("refund_type not in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeBetween(Integer value1, Integer value2) {
            addCriterion("refund_type between", value1, value2, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_type not between", value1, value2, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(Long value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(Long value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<Long> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdIsNull() {
            addCriterion("order_child_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdIsNotNull() {
            addCriterion("order_child_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdEqualTo(Long value) {
            addCriterion("order_child_id =", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdNotEqualTo(Long value) {
            addCriterion("order_child_id <>", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdGreaterThan(Long value) {
            addCriterion("order_child_id >", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_child_id >=", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdLessThan(Long value) {
            addCriterion("order_child_id <", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdLessThanOrEqualTo(Long value) {
            addCriterion("order_child_id <=", value, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdIn(List<Long> values) {
            addCriterion("order_child_id in", values, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdNotIn(List<Long> values) {
            addCriterion("order_child_id not in", values, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdBetween(Long value1, Long value2) {
            addCriterion("order_child_id between", value1, value2, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOrderChildIdNotBetween(Long value1, Long value2) {
            addCriterion("order_child_id not between", value1, value2, "orderChildId");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNull() {
            addCriterion("operation_date is null");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNotNull() {
            addCriterion("operation_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDateEqualTo(Date value) {
            addCriterion("operation_date =", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotEqualTo(Date value) {
            addCriterion("operation_date <>", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThan(Date value) {
            addCriterion("operation_date >", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_date >=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThan(Date value) {
            addCriterion("operation_date <", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThanOrEqualTo(Date value) {
            addCriterion("operation_date <=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateIn(List<Date> values) {
            addCriterion("operation_date in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotIn(List<Date> values) {
            addCriterion("operation_date not in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateBetween(Date value1, Date value2) {
            addCriterion("operation_date between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotBetween(Date value1, Date value2) {
            addCriterion("operation_date not between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(Integer value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(Integer value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(Integer value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(Integer value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<Integer> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<Integer> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(Integer value1, Integer value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformIsNull() {
            addCriterion("operation_platform is null");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformIsNotNull() {
            addCriterion("operation_platform is not null");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformEqualTo(Integer value) {
            addCriterion("operation_platform =", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformNotEqualTo(Integer value) {
            addCriterion("operation_platform <>", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformGreaterThan(Integer value) {
            addCriterion("operation_platform >", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_platform >=", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformLessThan(Integer value) {
            addCriterion("operation_platform <", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("operation_platform <=", value, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformIn(List<Integer> values) {
            addCriterion("operation_platform in", values, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformNotIn(List<Integer> values) {
            addCriterion("operation_platform not in", values, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformBetween(Integer value1, Integer value2) {
            addCriterion("operation_platform between", value1, value2, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperationPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_platform not between", value1, value2, "operationPlatform");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Long value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Long value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Long value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Long value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Long value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Long value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Long> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Long> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Long value1, Long value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Long value1, Long value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateIsNull() {
            addCriterion("order_before_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateIsNotNull() {
            addCriterion("order_before_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateEqualTo(Integer value) {
            addCriterion("order_before_state =", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateNotEqualTo(Integer value) {
            addCriterion("order_before_state <>", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateGreaterThan(Integer value) {
            addCriterion("order_before_state >", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_before_state >=", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateLessThan(Integer value) {
            addCriterion("order_before_state <", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_before_state <=", value, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateIn(List<Integer> values) {
            addCriterion("order_before_state in", values, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateNotIn(List<Integer> values) {
            addCriterion("order_before_state not in", values, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateBetween(Integer value1, Integer value2) {
            addCriterion("order_before_state between", value1, value2, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderBeforeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_before_state not between", value1, value2, "orderBeforeState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateIsNull() {
            addCriterion("order_current_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateIsNotNull() {
            addCriterion("order_current_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateEqualTo(Integer value) {
            addCriterion("order_current_state =", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateNotEqualTo(Integer value) {
            addCriterion("order_current_state <>", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateGreaterThan(Integer value) {
            addCriterion("order_current_state >", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_current_state >=", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateLessThan(Integer value) {
            addCriterion("order_current_state <", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_current_state <=", value, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateIn(List<Integer> values) {
            addCriterion("order_current_state in", values, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateNotIn(List<Integer> values) {
            addCriterion("order_current_state not in", values, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateBetween(Integer value1, Integer value2) {
            addCriterion("order_current_state between", value1, value2, "orderCurrentState");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_current_state not between", value1, value2, "orderCurrentState");
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