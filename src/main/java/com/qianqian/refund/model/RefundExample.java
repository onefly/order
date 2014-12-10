package com.qianqian.refund.model;

import com.framelib.utils.Page;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RefundExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andRefundStateIsNull() {
            addCriterion("refund_state is null");
            return (Criteria) this;
        }

        public Criteria andRefundStateIsNotNull() {
            addCriterion("refund_state is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStateEqualTo(Integer value) {
            addCriterion("refund_state =", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateNotEqualTo(Integer value) {
            addCriterion("refund_state <>", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateGreaterThan(Integer value) {
            addCriterion("refund_state >", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_state >=", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateLessThan(Integer value) {
            addCriterion("refund_state <", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateLessThanOrEqualTo(Integer value) {
            addCriterion("refund_state <=", value, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateIn(List<Integer> values) {
            addCriterion("refund_state in", values, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateNotIn(List<Integer> values) {
            addCriterion("refund_state not in", values, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateBetween(Integer value1, Integer value2) {
            addCriterion("refund_state between", value1, value2, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundStateNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_state not between", value1, value2, "refundState");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIsNull() {
            addCriterion("refund_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIsNotNull() {
            addCriterion("refund_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeEqualTo(Date value) {
            addCriterion("refund_create_time =", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotEqualTo(Date value) {
            addCriterion("refund_create_time <>", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeGreaterThan(Date value) {
            addCriterion("refund_create_time >", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_create_time >=", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeLessThan(Date value) {
            addCriterion("refund_create_time <", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_create_time <=", value, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeIn(List<Date> values) {
            addCriterion("refund_create_time in", values, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotIn(List<Date> values) {
            addCriterion("refund_create_time not in", values, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeBetween(Date value1, Date value2) {
            addCriterion("refund_create_time between", value1, value2, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andRefundCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_create_time not between", value1, value2, "refundCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andRefundRessonIsNull() {
            addCriterion("refund_resson is null");
            return (Criteria) this;
        }

        public Criteria andRefundRessonIsNotNull() {
            addCriterion("refund_resson is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRessonEqualTo(String value) {
            addCriterion("refund_resson =", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonNotEqualTo(String value) {
            addCriterion("refund_resson <>", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonGreaterThan(String value) {
            addCriterion("refund_resson >", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonGreaterThanOrEqualTo(String value) {
            addCriterion("refund_resson >=", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonLessThan(String value) {
            addCriterion("refund_resson <", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonLessThanOrEqualTo(String value) {
            addCriterion("refund_resson <=", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonLike(String value) {
            addCriterion("refund_resson like", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonNotLike(String value) {
            addCriterion("refund_resson not like", value, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonIn(List<String> values) {
            addCriterion("refund_resson in", values, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonNotIn(List<String> values) {
            addCriterion("refund_resson not in", values, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonBetween(String value1, String value2) {
            addCriterion("refund_resson between", value1, value2, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundRessonNotBetween(String value1, String value2) {
            addCriterion("refund_resson not between", value1, value2, "refundResson");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionIsNull() {
            addCriterion("refund_description is null");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionIsNotNull() {
            addCriterion("refund_description is not null");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionEqualTo(String value) {
            addCriterion("refund_description =", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionNotEqualTo(String value) {
            addCriterion("refund_description <>", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionGreaterThan(String value) {
            addCriterion("refund_description >", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("refund_description >=", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionLessThan(String value) {
            addCriterion("refund_description <", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionLessThanOrEqualTo(String value) {
            addCriterion("refund_description <=", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionLike(String value) {
            addCriterion("refund_description like", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionNotLike(String value) {
            addCriterion("refund_description not like", value, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionIn(List<String> values) {
            addCriterion("refund_description in", values, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionNotIn(List<String> values) {
            addCriterion("refund_description not in", values, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionBetween(String value1, String value2) {
            addCriterion("refund_description between", value1, value2, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andRefundDescriptionNotBetween(String value1, String value2) {
            addCriterion("refund_description not between", value1, value2, "refundDescription");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1IsNull() {
            addCriterion("voucher_pic1 is null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1IsNotNull() {
            addCriterion("voucher_pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1EqualTo(String value) {
            addCriterion("voucher_pic1 =", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1NotEqualTo(String value) {
            addCriterion("voucher_pic1 <>", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1GreaterThan(String value) {
            addCriterion("voucher_pic1 >", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1GreaterThanOrEqualTo(String value) {
            addCriterion("voucher_pic1 >=", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1LessThan(String value) {
            addCriterion("voucher_pic1 <", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1LessThanOrEqualTo(String value) {
            addCriterion("voucher_pic1 <=", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1Like(String value) {
            addCriterion("voucher_pic1 like", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1NotLike(String value) {
            addCriterion("voucher_pic1 not like", value, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1In(List<String> values) {
            addCriterion("voucher_pic1 in", values, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1NotIn(List<String> values) {
            addCriterion("voucher_pic1 not in", values, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1Between(String value1, String value2) {
            addCriterion("voucher_pic1 between", value1, value2, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic1NotBetween(String value1, String value2) {
            addCriterion("voucher_pic1 not between", value1, value2, "voucherPic1");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2IsNull() {
            addCriterion("voucher_pic2 is null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2IsNotNull() {
            addCriterion("voucher_pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2EqualTo(String value) {
            addCriterion("voucher_pic2 =", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2NotEqualTo(String value) {
            addCriterion("voucher_pic2 <>", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2GreaterThan(String value) {
            addCriterion("voucher_pic2 >", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2GreaterThanOrEqualTo(String value) {
            addCriterion("voucher_pic2 >=", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2LessThan(String value) {
            addCriterion("voucher_pic2 <", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2LessThanOrEqualTo(String value) {
            addCriterion("voucher_pic2 <=", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2Like(String value) {
            addCriterion("voucher_pic2 like", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2NotLike(String value) {
            addCriterion("voucher_pic2 not like", value, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2In(List<String> values) {
            addCriterion("voucher_pic2 in", values, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2NotIn(List<String> values) {
            addCriterion("voucher_pic2 not in", values, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2Between(String value1, String value2) {
            addCriterion("voucher_pic2 between", value1, value2, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic2NotBetween(String value1, String value2) {
            addCriterion("voucher_pic2 not between", value1, value2, "voucherPic2");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3IsNull() {
            addCriterion("voucher_pic3 is null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3IsNotNull() {
            addCriterion("voucher_pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3EqualTo(String value) {
            addCriterion("voucher_pic3 =", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3NotEqualTo(String value) {
            addCriterion("voucher_pic3 <>", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3GreaterThan(String value) {
            addCriterion("voucher_pic3 >", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3GreaterThanOrEqualTo(String value) {
            addCriterion("voucher_pic3 >=", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3LessThan(String value) {
            addCriterion("voucher_pic3 <", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3LessThanOrEqualTo(String value) {
            addCriterion("voucher_pic3 <=", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3Like(String value) {
            addCriterion("voucher_pic3 like", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3NotLike(String value) {
            addCriterion("voucher_pic3 not like", value, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3In(List<String> values) {
            addCriterion("voucher_pic3 in", values, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3NotIn(List<String> values) {
            addCriterion("voucher_pic3 not in", values, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3Between(String value1, String value2) {
            addCriterion("voucher_pic3 between", value1, value2, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andVoucherPic3NotBetween(String value1, String value2) {
            addCriterion("voucher_pic3 not between", value1, value2, "voucherPic3");
            return (Criteria) this;
        }

        public Criteria andAppealStateIsNull() {
            addCriterion("appeal_state is null");
            return (Criteria) this;
        }

        public Criteria andAppealStateIsNotNull() {
            addCriterion("appeal_state is not null");
            return (Criteria) this;
        }

        public Criteria andAppealStateEqualTo(Integer value) {
            addCriterion("appeal_state =", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateNotEqualTo(Integer value) {
            addCriterion("appeal_state <>", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateGreaterThan(Integer value) {
            addCriterion("appeal_state >", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("appeal_state >=", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateLessThan(Integer value) {
            addCriterion("appeal_state <", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateLessThanOrEqualTo(Integer value) {
            addCriterion("appeal_state <=", value, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateIn(List<Integer> values) {
            addCriterion("appeal_state in", values, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateNotIn(List<Integer> values) {
            addCriterion("appeal_state not in", values, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateBetween(Integer value1, Integer value2) {
            addCriterion("appeal_state between", value1, value2, "appealState");
            return (Criteria) this;
        }

        public Criteria andAppealStateNotBetween(Integer value1, Integer value2) {
            addCriterion("appeal_state not between", value1, value2, "appealState");
            return (Criteria) this;
        }

        public Criteria andOricountIsNull() {
            addCriterion("oricount is null");
            return (Criteria) this;
        }

        public Criteria andOricountIsNotNull() {
            addCriterion("oricount is not null");
            return (Criteria) this;
        }

        public Criteria andOricountEqualTo(Integer value) {
            addCriterion("oricount =", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountNotEqualTo(Integer value) {
            addCriterion("oricount <>", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountGreaterThan(Integer value) {
            addCriterion("oricount >", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountGreaterThanOrEqualTo(Integer value) {
            addCriterion("oricount >=", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountLessThan(Integer value) {
            addCriterion("oricount <", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountLessThanOrEqualTo(Integer value) {
            addCriterion("oricount <=", value, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountIn(List<Integer> values) {
            addCriterion("oricount in", values, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountNotIn(List<Integer> values) {
            addCriterion("oricount not in", values, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountBetween(Integer value1, Integer value2) {
            addCriterion("oricount between", value1, value2, "oricount");
            return (Criteria) this;
        }

        public Criteria andOricountNotBetween(Integer value1, Integer value2) {
            addCriterion("oricount not between", value1, value2, "oricount");
            return (Criteria) this;
        }

        public Criteria andPrdIdIsNull() {
            addCriterion("prd_id is null");
            return (Criteria) this;
        }

        public Criteria andPrdIdIsNotNull() {
            addCriterion("prd_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrdIdEqualTo(String value) {
            addCriterion("prd_id =", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotEqualTo(String value) {
            addCriterion("prd_id <>", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdGreaterThan(String value) {
            addCriterion("prd_id >", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("prd_id >=", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLessThan(String value) {
            addCriterion("prd_id <", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLessThanOrEqualTo(String value) {
            addCriterion("prd_id <=", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdLike(String value) {
            addCriterion("prd_id like", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotLike(String value) {
            addCriterion("prd_id not like", value, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdIn(List<String> values) {
            addCriterion("prd_id in", values, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotIn(List<String> values) {
            addCriterion("prd_id not in", values, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdBetween(String value1, String value2) {
            addCriterion("prd_id between", value1, value2, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdIdNotBetween(String value1, String value2) {
            addCriterion("prd_id not between", value1, value2, "prdId");
            return (Criteria) this;
        }

        public Criteria andPrdVersionIsNull() {
            addCriterion("prd_version is null");
            return (Criteria) this;
        }

        public Criteria andPrdVersionIsNotNull() {
            addCriterion("prd_version is not null");
            return (Criteria) this;
        }

        public Criteria andPrdVersionEqualTo(Integer value) {
            addCriterion("prd_version =", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionNotEqualTo(Integer value) {
            addCriterion("prd_version <>", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionGreaterThan(Integer value) {
            addCriterion("prd_version >", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("prd_version >=", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionLessThan(Integer value) {
            addCriterion("prd_version <", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionLessThanOrEqualTo(Integer value) {
            addCriterion("prd_version <=", value, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionIn(List<Integer> values) {
            addCriterion("prd_version in", values, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionNotIn(List<Integer> values) {
            addCriterion("prd_version not in", values, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionBetween(Integer value1, Integer value2) {
            addCriterion("prd_version between", value1, value2, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("prd_version not between", value1, value2, "prdVersion");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdIsNull() {
            addCriterion("prd_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdIsNotNull() {
            addCriterion("prd_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdEqualTo(Long value) {
            addCriterion("prd_standard_id =", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdNotEqualTo(Long value) {
            addCriterion("prd_standard_id <>", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdGreaterThan(Long value) {
            addCriterion("prd_standard_id >", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prd_standard_id >=", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdLessThan(Long value) {
            addCriterion("prd_standard_id <", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdLessThanOrEqualTo(Long value) {
            addCriterion("prd_standard_id <=", value, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdIn(List<Long> values) {
            addCriterion("prd_standard_id in", values, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdNotIn(List<Long> values) {
            addCriterion("prd_standard_id not in", values, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdBetween(Long value1, Long value2) {
            addCriterion("prd_standard_id between", value1, value2, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIdNotBetween(Long value1, Long value2) {
            addCriterion("prd_standard_id not between", value1, value2, "prdStandardId");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIsNull() {
            addCriterion("prd_standard is null");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIsNotNull() {
            addCriterion("prd_standard is not null");
            return (Criteria) this;
        }

        public Criteria andPrdStandardEqualTo(String value) {
            addCriterion("prd_standard =", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardNotEqualTo(String value) {
            addCriterion("prd_standard <>", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardGreaterThan(String value) {
            addCriterion("prd_standard >", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardGreaterThanOrEqualTo(String value) {
            addCriterion("prd_standard >=", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardLessThan(String value) {
            addCriterion("prd_standard <", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardLessThanOrEqualTo(String value) {
            addCriterion("prd_standard <=", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardLike(String value) {
            addCriterion("prd_standard like", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardNotLike(String value) {
            addCriterion("prd_standard not like", value, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardIn(List<String> values) {
            addCriterion("prd_standard in", values, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardNotIn(List<String> values) {
            addCriterion("prd_standard not in", values, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardBetween(String value1, String value2) {
            addCriterion("prd_standard between", value1, value2, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdStandardNotBetween(String value1, String value2) {
            addCriterion("prd_standard not between", value1, value2, "prdStandard");
            return (Criteria) this;
        }

        public Criteria andPrdCodeIsNull() {
            addCriterion("prd_code is null");
            return (Criteria) this;
        }

        public Criteria andPrdCodeIsNotNull() {
            addCriterion("prd_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrdCodeEqualTo(Long value) {
            addCriterion("prd_code =", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeNotEqualTo(Long value) {
            addCriterion("prd_code <>", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeGreaterThan(Long value) {
            addCriterion("prd_code >", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("prd_code >=", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeLessThan(Long value) {
            addCriterion("prd_code <", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeLessThanOrEqualTo(Long value) {
            addCriterion("prd_code <=", value, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeIn(List<Long> values) {
            addCriterion("prd_code in", values, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeNotIn(List<Long> values) {
            addCriterion("prd_code not in", values, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeBetween(Long value1, Long value2) {
            addCriterion("prd_code between", value1, value2, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdCodeNotBetween(Long value1, Long value2) {
            addCriterion("prd_code not between", value1, value2, "prdCode");
            return (Criteria) this;
        }

        public Criteria andPrdNameIsNull() {
            addCriterion("prd_name is null");
            return (Criteria) this;
        }

        public Criteria andPrdNameIsNotNull() {
            addCriterion("prd_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrdNameEqualTo(String value) {
            addCriterion("prd_name =", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameNotEqualTo(String value) {
            addCriterion("prd_name <>", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameGreaterThan(String value) {
            addCriterion("prd_name >", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameGreaterThanOrEqualTo(String value) {
            addCriterion("prd_name >=", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameLessThan(String value) {
            addCriterion("prd_name <", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameLessThanOrEqualTo(String value) {
            addCriterion("prd_name <=", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameLike(String value) {
            addCriterion("prd_name like", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameNotLike(String value) {
            addCriterion("prd_name not like", value, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameIn(List<String> values) {
            addCriterion("prd_name in", values, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameNotIn(List<String> values) {
            addCriterion("prd_name not in", values, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameBetween(String value1, String value2) {
            addCriterion("prd_name between", value1, value2, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdNameNotBetween(String value1, String value2) {
            addCriterion("prd_name not between", value1, value2, "prdName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdIsNull() {
            addCriterion("prd_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdIsNotNull() {
            addCriterion("prd_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdEqualTo(Long value) {
            addCriterion("prd_brand_id =", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdNotEqualTo(Long value) {
            addCriterion("prd_brand_id <>", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdGreaterThan(Long value) {
            addCriterion("prd_brand_id >", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prd_brand_id >=", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdLessThan(Long value) {
            addCriterion("prd_brand_id <", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("prd_brand_id <=", value, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdIn(List<Long> values) {
            addCriterion("prd_brand_id in", values, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdNotIn(List<Long> values) {
            addCriterion("prd_brand_id not in", values, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdBetween(Long value1, Long value2) {
            addCriterion("prd_brand_id between", value1, value2, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("prd_brand_id not between", value1, value2, "prdBrandId");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameIsNull() {
            addCriterion("prd_brand_name is null");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameIsNotNull() {
            addCriterion("prd_brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameEqualTo(String value) {
            addCriterion("prd_brand_name =", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameNotEqualTo(String value) {
            addCriterion("prd_brand_name <>", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameGreaterThan(String value) {
            addCriterion("prd_brand_name >", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("prd_brand_name >=", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameLessThan(String value) {
            addCriterion("prd_brand_name <", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameLessThanOrEqualTo(String value) {
            addCriterion("prd_brand_name <=", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameLike(String value) {
            addCriterion("prd_brand_name like", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameNotLike(String value) {
            addCriterion("prd_brand_name not like", value, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameIn(List<String> values) {
            addCriterion("prd_brand_name in", values, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameNotIn(List<String> values) {
            addCriterion("prd_brand_name not in", values, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameBetween(String value1, String value2) {
            addCriterion("prd_brand_name between", value1, value2, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdBrandNameNotBetween(String value1, String value2) {
            addCriterion("prd_brand_name not between", value1, value2, "prdBrandName");
            return (Criteria) this;
        }

        public Criteria andPrdPicIsNull() {
            addCriterion("prd_pic is null");
            return (Criteria) this;
        }

        public Criteria andPrdPicIsNotNull() {
            addCriterion("prd_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPrdPicEqualTo(String value) {
            addCriterion("prd_pic =", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicNotEqualTo(String value) {
            addCriterion("prd_pic <>", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicGreaterThan(String value) {
            addCriterion("prd_pic >", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicGreaterThanOrEqualTo(String value) {
            addCriterion("prd_pic >=", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicLessThan(String value) {
            addCriterion("prd_pic <", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicLessThanOrEqualTo(String value) {
            addCriterion("prd_pic <=", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicLike(String value) {
            addCriterion("prd_pic like", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicNotLike(String value) {
            addCriterion("prd_pic not like", value, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicIn(List<String> values) {
            addCriterion("prd_pic in", values, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicNotIn(List<String> values) {
            addCriterion("prd_pic not in", values, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicBetween(String value1, String value2) {
            addCriterion("prd_pic between", value1, value2, "prdPic");
            return (Criteria) this;
        }

        public Criteria andPrdPicNotBetween(String value1, String value2) {
            addCriterion("prd_pic not between", value1, value2, "prdPic");
            return (Criteria) this;
        }

        public Criteria andStanColorNameIsNull() {
            addCriterion("stan_color_name is null");
            return (Criteria) this;
        }

        public Criteria andStanColorNameIsNotNull() {
            addCriterion("stan_color_name is not null");
            return (Criteria) this;
        }

        public Criteria andStanColorNameEqualTo(String value) {
            addCriterion("stan_color_name =", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameNotEqualTo(String value) {
            addCriterion("stan_color_name <>", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameGreaterThan(String value) {
            addCriterion("stan_color_name >", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameGreaterThanOrEqualTo(String value) {
            addCriterion("stan_color_name >=", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameLessThan(String value) {
            addCriterion("stan_color_name <", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameLessThanOrEqualTo(String value) {
            addCriterion("stan_color_name <=", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameLike(String value) {
            addCriterion("stan_color_name like", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameNotLike(String value) {
            addCriterion("stan_color_name not like", value, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameIn(List<String> values) {
            addCriterion("stan_color_name in", values, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameNotIn(List<String> values) {
            addCriterion("stan_color_name not in", values, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameBetween(String value1, String value2) {
            addCriterion("stan_color_name between", value1, value2, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorNameNotBetween(String value1, String value2) {
            addCriterion("stan_color_name not between", value1, value2, "stanColorName");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeIsNull() {
            addCriterion("stan_color_code is null");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeIsNotNull() {
            addCriterion("stan_color_code is not null");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeEqualTo(Integer value) {
            addCriterion("stan_color_code =", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeNotEqualTo(Integer value) {
            addCriterion("stan_color_code <>", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeGreaterThan(Integer value) {
            addCriterion("stan_color_code >", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stan_color_code >=", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeLessThan(Integer value) {
            addCriterion("stan_color_code <", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeLessThanOrEqualTo(Integer value) {
            addCriterion("stan_color_code <=", value, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeIn(List<Integer> values) {
            addCriterion("stan_color_code in", values, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeNotIn(List<Integer> values) {
            addCriterion("stan_color_code not in", values, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeBetween(Integer value1, Integer value2) {
            addCriterion("stan_color_code between", value1, value2, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanColorCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("stan_color_code not between", value1, value2, "stanColorCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameIsNull() {
            addCriterion("stan_size_name is null");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameIsNotNull() {
            addCriterion("stan_size_name is not null");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameEqualTo(String value) {
            addCriterion("stan_size_name =", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameNotEqualTo(String value) {
            addCriterion("stan_size_name <>", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameGreaterThan(String value) {
            addCriterion("stan_size_name >", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("stan_size_name >=", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameLessThan(String value) {
            addCriterion("stan_size_name <", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameLessThanOrEqualTo(String value) {
            addCriterion("stan_size_name <=", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameLike(String value) {
            addCriterion("stan_size_name like", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameNotLike(String value) {
            addCriterion("stan_size_name not like", value, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameIn(List<String> values) {
            addCriterion("stan_size_name in", values, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameNotIn(List<String> values) {
            addCriterion("stan_size_name not in", values, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameBetween(String value1, String value2) {
            addCriterion("stan_size_name between", value1, value2, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeNameNotBetween(String value1, String value2) {
            addCriterion("stan_size_name not between", value1, value2, "stanSizeName");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeIsNull() {
            addCriterion("stan_size_code is null");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeIsNotNull() {
            addCriterion("stan_size_code is not null");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeEqualTo(Integer value) {
            addCriterion("stan_size_code =", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeNotEqualTo(Integer value) {
            addCriterion("stan_size_code <>", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeGreaterThan(Integer value) {
            addCriterion("stan_size_code >", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stan_size_code >=", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeLessThan(Integer value) {
            addCriterion("stan_size_code <", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("stan_size_code <=", value, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeIn(List<Integer> values) {
            addCriterion("stan_size_code in", values, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeNotIn(List<Integer> values) {
            addCriterion("stan_size_code not in", values, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeBetween(Integer value1, Integer value2) {
            addCriterion("stan_size_code between", value1, value2, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andStanSizeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("stan_size_code not between", value1, value2, "stanSizeCode");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Long value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameIsNull() {
            addCriterion("buyer_nickname is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameIsNotNull() {
            addCriterion("buyer_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameEqualTo(String value) {
            addCriterion("buyer_nickname =", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameNotEqualTo(String value) {
            addCriterion("buyer_nickname <>", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameGreaterThan(String value) {
            addCriterion("buyer_nickname >", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_nickname >=", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameLessThan(String value) {
            addCriterion("buyer_nickname <", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameLessThanOrEqualTo(String value) {
            addCriterion("buyer_nickname <=", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameLike(String value) {
            addCriterion("buyer_nickname like", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameNotLike(String value) {
            addCriterion("buyer_nickname not like", value, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameIn(List<String> values) {
            addCriterion("buyer_nickname in", values, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameNotIn(List<String> values) {
            addCriterion("buyer_nickname not in", values, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameBetween(String value1, String value2) {
            addCriterion("buyer_nickname between", value1, value2, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerNicknameNotBetween(String value1, String value2) {
            addCriterion("buyer_nickname not between", value1, value2, "buyerNickname");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActiPurposeIsNull() {
            addCriterion("acti_purpose is null");
            return (Criteria) this;
        }

        public Criteria andActiPurposeIsNotNull() {
            addCriterion("acti_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andActiPurposeEqualTo(String value) {
            addCriterion("acti_purpose =", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeNotEqualTo(String value) {
            addCriterion("acti_purpose <>", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeGreaterThan(String value) {
            addCriterion("acti_purpose >", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("acti_purpose >=", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeLessThan(String value) {
            addCriterion("acti_purpose <", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeLessThanOrEqualTo(String value) {
            addCriterion("acti_purpose <=", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeLike(String value) {
            addCriterion("acti_purpose like", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeNotLike(String value) {
            addCriterion("acti_purpose not like", value, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeIn(List<String> values) {
            addCriterion("acti_purpose in", values, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeNotIn(List<String> values) {
            addCriterion("acti_purpose not in", values, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeBetween(String value1, String value2) {
            addCriterion("acti_purpose between", value1, value2, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andActiPurposeNotBetween(String value1, String value2) {
            addCriterion("acti_purpose not between", value1, value2, "actiPurpose");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeIsNull() {
            addCriterion("sys_agree_refund_application_time is null");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeIsNotNull() {
            addCriterion("sys_agree_refund_application_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeEqualTo(Date value) {
            addCriterion("sys_agree_refund_application_time =", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeNotEqualTo(Date value) {
            addCriterion("sys_agree_refund_application_time <>", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeGreaterThan(Date value) {
            addCriterion("sys_agree_refund_application_time >", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_agree_refund_application_time >=", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeLessThan(Date value) {
            addCriterion("sys_agree_refund_application_time <", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_agree_refund_application_time <=", value, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeIn(List<Date> values) {
            addCriterion("sys_agree_refund_application_time in", values, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeNotIn(List<Date> values) {
            addCriterion("sys_agree_refund_application_time not in", values, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("sys_agree_refund_application_time between", value1, value2, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_agree_refund_application_time not between", value1, value2, "sysAgreeRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeIsNull() {
            addCriterion("sys_close_refund_application_intervene_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeIsNotNull() {
            addCriterion("sys_close_refund_application_intervene_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeEqualTo(Date value) {
            addCriterion("sys_close_refund_application_intervene_time =", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeNotEqualTo(Date value) {
            addCriterion("sys_close_refund_application_intervene_time <>", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeGreaterThan(Date value) {
            addCriterion("sys_close_refund_application_intervene_time >", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_application_intervene_time >=", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeLessThan(Date value) {
            addCriterion("sys_close_refund_application_intervene_time <", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_application_intervene_time <=", value, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeIn(List<Date> values) {
            addCriterion("sys_close_refund_application_intervene_time in", values, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeNotIn(List<Date> values) {
            addCriterion("sys_close_refund_application_intervene_time not in", values, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_application_intervene_time between", value1, value2, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationInterveneTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_application_intervene_time not between", value1, value2, "sysCloseRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeIsNull() {
            addCriterion("sys_wanning_refund_application_intervene_time is null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeIsNotNull() {
            addCriterion("sys_wanning_refund_application_intervene_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeEqualTo(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time =", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeNotEqualTo(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time <>", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeGreaterThan(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time >", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time >=", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeLessThan(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time <", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_application_intervene_time <=", value, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeIn(List<Date> values) {
            addCriterion("sys_wanning_refund_application_intervene_time in", values, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeNotIn(List<Date> values) {
            addCriterion("sys_wanning_refund_application_intervene_time not in", values, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_application_intervene_time between", value1, value2, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundApplicationInterveneTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_application_intervene_time not between", value1, value2, "sysWanningRefundApplicationInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeIsNull() {
            addCriterion("sys_close_refund_application_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeIsNotNull() {
            addCriterion("sys_close_refund_application_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeEqualTo(Date value) {
            addCriterion("sys_close_refund_application_time =", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeNotEqualTo(Date value) {
            addCriterion("sys_close_refund_application_time <>", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeGreaterThan(Date value) {
            addCriterion("sys_close_refund_application_time >", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_application_time >=", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeLessThan(Date value) {
            addCriterion("sys_close_refund_application_time <", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_application_time <=", value, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeIn(List<Date> values) {
            addCriterion("sys_close_refund_application_time in", values, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeNotIn(List<Date> values) {
            addCriterion("sys_close_refund_application_time not in", values, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_application_time between", value1, value2, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_application_time not between", value1, value2, "sysCloseRefundApplicationTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeIsNull() {
            addCriterion("sys_agree_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeIsNotNull() {
            addCriterion("sys_agree_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeEqualTo(Date value) {
            addCriterion("sys_agree_refund_time =", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeNotEqualTo(Date value) {
            addCriterion("sys_agree_refund_time <>", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeGreaterThan(Date value) {
            addCriterion("sys_agree_refund_time >", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_agree_refund_time >=", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeLessThan(Date value) {
            addCriterion("sys_agree_refund_time <", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_agree_refund_time <=", value, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeIn(List<Date> values) {
            addCriterion("sys_agree_refund_time in", values, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeNotIn(List<Date> values) {
            addCriterion("sys_agree_refund_time not in", values, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeBetween(Date value1, Date value2) {
            addCriterion("sys_agree_refund_time between", value1, value2, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysAgreeRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_agree_refund_time not between", value1, value2, "sysAgreeRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeIsNull() {
            addCriterion("sys_close_refund_intervene_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeIsNotNull() {
            addCriterion("sys_close_refund_intervene_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeEqualTo(Date value) {
            addCriterion("sys_close_refund_intervene_time =", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeNotEqualTo(Date value) {
            addCriterion("sys_close_refund_intervene_time <>", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeGreaterThan(Date value) {
            addCriterion("sys_close_refund_intervene_time >", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_intervene_time >=", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeLessThan(Date value) {
            addCriterion("sys_close_refund_intervene_time <", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_close_refund_intervene_time <=", value, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeIn(List<Date> values) {
            addCriterion("sys_close_refund_intervene_time in", values, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeNotIn(List<Date> values) {
            addCriterion("sys_close_refund_intervene_time not in", values, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_intervene_time between", value1, value2, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseRefundInterveneTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_close_refund_intervene_time not between", value1, value2, "sysCloseRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeIsNull() {
            addCriterion("sys_wanning_refund_intervene_time is null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeIsNotNull() {
            addCriterion("sys_wanning_refund_intervene_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeEqualTo(Date value) {
            addCriterion("sys_wanning_refund_intervene_time =", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeNotEqualTo(Date value) {
            addCriterion("sys_wanning_refund_intervene_time <>", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeGreaterThan(Date value) {
            addCriterion("sys_wanning_refund_intervene_time >", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_intervene_time >=", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeLessThan(Date value) {
            addCriterion("sys_wanning_refund_intervene_time <", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_intervene_time <=", value, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeIn(List<Date> values) {
            addCriterion("sys_wanning_refund_intervene_time in", values, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeNotIn(List<Date> values) {
            addCriterion("sys_wanning_refund_intervene_time not in", values, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_intervene_time between", value1, value2, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundInterveneTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_intervene_time not between", value1, value2, "sysWanningRefundInterveneTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeIsNull() {
            addCriterion("sys_wanning_refund_affirm_time is null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeIsNotNull() {
            addCriterion("sys_wanning_refund_affirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeEqualTo(Date value) {
            addCriterion("sys_wanning_refund_affirm_time =", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeNotEqualTo(Date value) {
            addCriterion("sys_wanning_refund_affirm_time <>", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeGreaterThan(Date value) {
            addCriterion("sys_wanning_refund_affirm_time >", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_affirm_time >=", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeLessThan(Date value) {
            addCriterion("sys_wanning_refund_affirm_time <", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_wanning_refund_affirm_time <=", value, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeIn(List<Date> values) {
            addCriterion("sys_wanning_refund_affirm_time in", values, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeNotIn(List<Date> values) {
            addCriterion("sys_wanning_refund_affirm_time not in", values, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_affirm_time between", value1, value2, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysWanningRefundAffirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_wanning_refund_affirm_time not between", value1, value2, "sysWanningRefundAffirmTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeIsNull() {
            addCriterion("sys_close_appeal_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeIsNotNull() {
            addCriterion("sys_close_appeal_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeEqualTo(Date value) {
            addCriterion("sys_close_appeal_time =", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeNotEqualTo(Date value) {
            addCriterion("sys_close_appeal_time <>", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeGreaterThan(Date value) {
            addCriterion("sys_close_appeal_time >", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_close_appeal_time >=", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeLessThan(Date value) {
            addCriterion("sys_close_appeal_time <", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_close_appeal_time <=", value, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeIn(List<Date> values) {
            addCriterion("sys_close_appeal_time in", values, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeNotIn(List<Date> values) {
            addCriterion("sys_close_appeal_time not in", values, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeBetween(Date value1, Date value2) {
            addCriterion("sys_close_appeal_time between", value1, value2, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andSysCloseAppealTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_close_appeal_time not between", value1, value2, "sysCloseAppealTime");
            return (Criteria) this;
        }

        public Criteria andPriceOrderIsNull() {
            addCriterion("price_order is null");
            return (Criteria) this;
        }

        public Criteria andPriceOrderIsNotNull() {
            addCriterion("price_order is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOrderEqualTo(BigDecimal value) {
            addCriterion("price_order =", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderNotEqualTo(BigDecimal value) {
            addCriterion("price_order <>", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderGreaterThan(BigDecimal value) {
            addCriterion("price_order >", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_order >=", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderLessThan(BigDecimal value) {
            addCriterion("price_order <", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_order <=", value, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderIn(List<BigDecimal> values) {
            addCriterion("price_order in", values, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderNotIn(List<BigDecimal> values) {
            addCriterion("price_order not in", values, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_order between", value1, value2, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_order not between", value1, value2, "priceOrder");
            return (Criteria) this;
        }

        public Criteria andPriceRefundIsNull() {
            addCriterion("price_refund is null");
            return (Criteria) this;
        }

        public Criteria andPriceRefundIsNotNull() {
            addCriterion("price_refund is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRefundEqualTo(BigDecimal value) {
            addCriterion("price_refund =", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundNotEqualTo(BigDecimal value) {
            addCriterion("price_refund <>", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundGreaterThan(BigDecimal value) {
            addCriterion("price_refund >", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_refund >=", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundLessThan(BigDecimal value) {
            addCriterion("price_refund <", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_refund <=", value, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundIn(List<BigDecimal> values) {
            addCriterion("price_refund in", values, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundNotIn(List<BigDecimal> values) {
            addCriterion("price_refund not in", values, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_refund between", value1, value2, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andPriceRefundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_refund not between", value1, value2, "priceRefund");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameIsNull() {
            addCriterion("addr_province_name is null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameIsNotNull() {
            addCriterion("addr_province_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameEqualTo(String value) {
            addCriterion("addr_province_name =", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameNotEqualTo(String value) {
            addCriterion("addr_province_name <>", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameGreaterThan(String value) {
            addCriterion("addr_province_name >", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_province_name >=", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameLessThan(String value) {
            addCriterion("addr_province_name <", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("addr_province_name <=", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameLike(String value) {
            addCriterion("addr_province_name like", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameNotLike(String value) {
            addCriterion("addr_province_name not like", value, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameIn(List<String> values) {
            addCriterion("addr_province_name in", values, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameNotIn(List<String> values) {
            addCriterion("addr_province_name not in", values, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameBetween(String value1, String value2) {
            addCriterion("addr_province_name between", value1, value2, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNameNotBetween(String value1, String value2) {
            addCriterion("addr_province_name not between", value1, value2, "addrProvinceName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameIsNull() {
            addCriterion("addr_city_name is null");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameIsNotNull() {
            addCriterion("addr_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameEqualTo(String value) {
            addCriterion("addr_city_name =", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameNotEqualTo(String value) {
            addCriterion("addr_city_name <>", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameGreaterThan(String value) {
            addCriterion("addr_city_name >", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_city_name >=", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameLessThan(String value) {
            addCriterion("addr_city_name <", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameLessThanOrEqualTo(String value) {
            addCriterion("addr_city_name <=", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameLike(String value) {
            addCriterion("addr_city_name like", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameNotLike(String value) {
            addCriterion("addr_city_name not like", value, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameIn(List<String> values) {
            addCriterion("addr_city_name in", values, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameNotIn(List<String> values) {
            addCriterion("addr_city_name not in", values, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameBetween(String value1, String value2) {
            addCriterion("addr_city_name between", value1, value2, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrCityNameNotBetween(String value1, String value2) {
            addCriterion("addr_city_name not between", value1, value2, "addrCityName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameIsNull() {
            addCriterion("addr_district_name is null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameIsNotNull() {
            addCriterion("addr_district_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameEqualTo(String value) {
            addCriterion("addr_district_name =", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameNotEqualTo(String value) {
            addCriterion("addr_district_name <>", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameGreaterThan(String value) {
            addCriterion("addr_district_name >", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_district_name >=", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameLessThan(String value) {
            addCriterion("addr_district_name <", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("addr_district_name <=", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameLike(String value) {
            addCriterion("addr_district_name like", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameNotLike(String value) {
            addCriterion("addr_district_name not like", value, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameIn(List<String> values) {
            addCriterion("addr_district_name in", values, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameNotIn(List<String> values) {
            addCriterion("addr_district_name not in", values, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameBetween(String value1, String value2) {
            addCriterion("addr_district_name between", value1, value2, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNameNotBetween(String value1, String value2) {
            addCriterion("addr_district_name not between", value1, value2, "addrDistrictName");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdIsNull() {
            addCriterion("addr_province_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdIsNotNull() {
            addCriterion("addr_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdEqualTo(Integer value) {
            addCriterion("addr_province_id =", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdNotEqualTo(Integer value) {
            addCriterion("addr_province_id <>", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdGreaterThan(Integer value) {
            addCriterion("addr_province_id >", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_province_id >=", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdLessThan(Integer value) {
            addCriterion("addr_province_id <", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("addr_province_id <=", value, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdIn(List<Integer> values) {
            addCriterion("addr_province_id in", values, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdNotIn(List<Integer> values) {
            addCriterion("addr_province_id not in", values, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("addr_province_id between", value1, value2, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_province_id not between", value1, value2, "addrProvinceId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdIsNull() {
            addCriterion("addr_city_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdIsNotNull() {
            addCriterion("addr_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdEqualTo(Integer value) {
            addCriterion("addr_city_id =", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdNotEqualTo(Integer value) {
            addCriterion("addr_city_id <>", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdGreaterThan(Integer value) {
            addCriterion("addr_city_id >", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_city_id >=", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdLessThan(Integer value) {
            addCriterion("addr_city_id <", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("addr_city_id <=", value, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdIn(List<Integer> values) {
            addCriterion("addr_city_id in", values, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdNotIn(List<Integer> values) {
            addCriterion("addr_city_id not in", values, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdBetween(Integer value1, Integer value2) {
            addCriterion("addr_city_id between", value1, value2, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_city_id not between", value1, value2, "addrCityId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdIsNull() {
            addCriterion("addr_district_id is null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdIsNotNull() {
            addCriterion("addr_district_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdEqualTo(Integer value) {
            addCriterion("addr_district_id =", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdNotEqualTo(Integer value) {
            addCriterion("addr_district_id <>", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdGreaterThan(Integer value) {
            addCriterion("addr_district_id >", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_district_id >=", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdLessThan(Integer value) {
            addCriterion("addr_district_id <", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("addr_district_id <=", value, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdIn(List<Integer> values) {
            addCriterion("addr_district_id in", values, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdNotIn(List<Integer> values) {
            addCriterion("addr_district_id not in", values, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdBetween(Integer value1, Integer value2) {
            addCriterion("addr_district_id between", value1, value2, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_district_id not between", value1, value2, "addrDistrictId");
            return (Criteria) this;
        }

        public Criteria andAddrAddressIsNull() {
            addCriterion("addr_address is null");
            return (Criteria) this;
        }

        public Criteria andAddrAddressIsNotNull() {
            addCriterion("addr_address is not null");
            return (Criteria) this;
        }

        public Criteria andAddrAddressEqualTo(String value) {
            addCriterion("addr_address =", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressNotEqualTo(String value) {
            addCriterion("addr_address <>", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressGreaterThan(String value) {
            addCriterion("addr_address >", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressGreaterThanOrEqualTo(String value) {
            addCriterion("addr_address >=", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressLessThan(String value) {
            addCriterion("addr_address <", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressLessThanOrEqualTo(String value) {
            addCriterion("addr_address <=", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressLike(String value) {
            addCriterion("addr_address like", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressNotLike(String value) {
            addCriterion("addr_address not like", value, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressIn(List<String> values) {
            addCriterion("addr_address in", values, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressNotIn(List<String> values) {
            addCriterion("addr_address not in", values, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressBetween(String value1, String value2) {
            addCriterion("addr_address between", value1, value2, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrAddressNotBetween(String value1, String value2) {
            addCriterion("addr_address not between", value1, value2, "addrAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressIsNull() {
            addCriterion("addr_full_address is null");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressIsNotNull() {
            addCriterion("addr_full_address is not null");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressEqualTo(String value) {
            addCriterion("addr_full_address =", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressNotEqualTo(String value) {
            addCriterion("addr_full_address <>", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressGreaterThan(String value) {
            addCriterion("addr_full_address >", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressGreaterThanOrEqualTo(String value) {
            addCriterion("addr_full_address >=", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressLessThan(String value) {
            addCriterion("addr_full_address <", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressLessThanOrEqualTo(String value) {
            addCriterion("addr_full_address <=", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressLike(String value) {
            addCriterion("addr_full_address like", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressNotLike(String value) {
            addCriterion("addr_full_address not like", value, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressIn(List<String> values) {
            addCriterion("addr_full_address in", values, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressNotIn(List<String> values) {
            addCriterion("addr_full_address not in", values, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressBetween(String value1, String value2) {
            addCriterion("addr_full_address between", value1, value2, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrFullAddressNotBetween(String value1, String value2) {
            addCriterion("addr_full_address not between", value1, value2, "addrFullAddress");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameIsNull() {
            addCriterion("addr_recieve_name is null");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameIsNotNull() {
            addCriterion("addr_recieve_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameEqualTo(String value) {
            addCriterion("addr_recieve_name =", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameNotEqualTo(String value) {
            addCriterion("addr_recieve_name <>", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameGreaterThan(String value) {
            addCriterion("addr_recieve_name >", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_recieve_name >=", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameLessThan(String value) {
            addCriterion("addr_recieve_name <", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameLessThanOrEqualTo(String value) {
            addCriterion("addr_recieve_name <=", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameLike(String value) {
            addCriterion("addr_recieve_name like", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameNotLike(String value) {
            addCriterion("addr_recieve_name not like", value, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameIn(List<String> values) {
            addCriterion("addr_recieve_name in", values, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameNotIn(List<String> values) {
            addCriterion("addr_recieve_name not in", values, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameBetween(String value1, String value2) {
            addCriterion("addr_recieve_name between", value1, value2, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveNameNotBetween(String value1, String value2) {
            addCriterion("addr_recieve_name not between", value1, value2, "addrRecieveName");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeIsNull() {
            addCriterion("addr_zip_code is null");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeIsNotNull() {
            addCriterion("addr_zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeEqualTo(String value) {
            addCriterion("addr_zip_code =", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeNotEqualTo(String value) {
            addCriterion("addr_zip_code <>", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeGreaterThan(String value) {
            addCriterion("addr_zip_code >", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("addr_zip_code >=", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeLessThan(String value) {
            addCriterion("addr_zip_code <", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeLessThanOrEqualTo(String value) {
            addCriterion("addr_zip_code <=", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeLike(String value) {
            addCriterion("addr_zip_code like", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeNotLike(String value) {
            addCriterion("addr_zip_code not like", value, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeIn(List<String> values) {
            addCriterion("addr_zip_code in", values, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeNotIn(List<String> values) {
            addCriterion("addr_zip_code not in", values, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeBetween(String value1, String value2) {
            addCriterion("addr_zip_code between", value1, value2, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrZipCodeNotBetween(String value1, String value2) {
            addCriterion("addr_zip_code not between", value1, value2, "addrZipCode");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileIsNull() {
            addCriterion("addr_recieve_mobile is null");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileIsNotNull() {
            addCriterion("addr_recieve_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileEqualTo(String value) {
            addCriterion("addr_recieve_mobile =", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileNotEqualTo(String value) {
            addCriterion("addr_recieve_mobile <>", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileGreaterThan(String value) {
            addCriterion("addr_recieve_mobile >", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileGreaterThanOrEqualTo(String value) {
            addCriterion("addr_recieve_mobile >=", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileLessThan(String value) {
            addCriterion("addr_recieve_mobile <", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileLessThanOrEqualTo(String value) {
            addCriterion("addr_recieve_mobile <=", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileLike(String value) {
            addCriterion("addr_recieve_mobile like", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileNotLike(String value) {
            addCriterion("addr_recieve_mobile not like", value, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileIn(List<String> values) {
            addCriterion("addr_recieve_mobile in", values, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileNotIn(List<String> values) {
            addCriterion("addr_recieve_mobile not in", values, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileBetween(String value1, String value2) {
            addCriterion("addr_recieve_mobile between", value1, value2, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecieveMobileNotBetween(String value1, String value2) {
            addCriterion("addr_recieve_mobile not between", value1, value2, "addrRecieveMobile");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneIsNull() {
            addCriterion("addr_recieve_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneIsNotNull() {
            addCriterion("addr_recieve_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneEqualTo(String value) {
            addCriterion("addr_recieve_phone =", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneNotEqualTo(String value) {
            addCriterion("addr_recieve_phone <>", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneGreaterThan(String value) {
            addCriterion("addr_recieve_phone >", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("addr_recieve_phone >=", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneLessThan(String value) {
            addCriterion("addr_recieve_phone <", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneLessThanOrEqualTo(String value) {
            addCriterion("addr_recieve_phone <=", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneLike(String value) {
            addCriterion("addr_recieve_phone like", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneNotLike(String value) {
            addCriterion("addr_recieve_phone not like", value, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneIn(List<String> values) {
            addCriterion("addr_recieve_phone in", values, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneNotIn(List<String> values) {
            addCriterion("addr_recieve_phone not in", values, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneBetween(String value1, String value2) {
            addCriterion("addr_recieve_phone between", value1, value2, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andAddrRecievePhoneNotBetween(String value1, String value2) {
            addCriterion("addr_recieve_phone not between", value1, value2, "addrRecievePhone");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersIsNull() {
            addCriterion("express_numbers is null");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersIsNotNull() {
            addCriterion("express_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersEqualTo(String value) {
            addCriterion("express_numbers =", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersNotEqualTo(String value) {
            addCriterion("express_numbers <>", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersGreaterThan(String value) {
            addCriterion("express_numbers >", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersGreaterThanOrEqualTo(String value) {
            addCriterion("express_numbers >=", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersLessThan(String value) {
            addCriterion("express_numbers <", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersLessThanOrEqualTo(String value) {
            addCriterion("express_numbers <=", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersLike(String value) {
            addCriterion("express_numbers like", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersNotLike(String value) {
            addCriterion("express_numbers not like", value, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersIn(List<String> values) {
            addCriterion("express_numbers in", values, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersNotIn(List<String> values) {
            addCriterion("express_numbers not in", values, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersBetween(String value1, String value2) {
            addCriterion("express_numbers between", value1, value2, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressNumbersNotBetween(String value1, String value2) {
            addCriterion("express_numbers not between", value1, value2, "expressNumbers");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("express_company in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("express_company not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonIsNull() {
            addCriterion("brand_refuse_reason is null");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonIsNotNull() {
            addCriterion("brand_refuse_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonEqualTo(String value) {
            addCriterion("brand_refuse_reason =", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonNotEqualTo(String value) {
            addCriterion("brand_refuse_reason <>", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonGreaterThan(String value) {
            addCriterion("brand_refuse_reason >", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("brand_refuse_reason >=", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonLessThan(String value) {
            addCriterion("brand_refuse_reason <", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("brand_refuse_reason <=", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonLike(String value) {
            addCriterion("brand_refuse_reason like", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonNotLike(String value) {
            addCriterion("brand_refuse_reason not like", value, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonIn(List<String> values) {
            addCriterion("brand_refuse_reason in", values, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonNotIn(List<String> values) {
            addCriterion("brand_refuse_reason not in", values, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonBetween(String value1, String value2) {
            addCriterion("brand_refuse_reason between", value1, value2, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBrandRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("brand_refuse_reason not between", value1, value2, "brandRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonIsNull() {
            addCriterion("maxtp_refuse_reason is null");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonIsNotNull() {
            addCriterion("maxtp_refuse_reason is not null");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonEqualTo(String value) {
            addCriterion("maxtp_refuse_reason =", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonNotEqualTo(String value) {
            addCriterion("maxtp_refuse_reason <>", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonGreaterThan(String value) {
            addCriterion("maxtp_refuse_reason >", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("maxtp_refuse_reason >=", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonLessThan(String value) {
            addCriterion("maxtp_refuse_reason <", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("maxtp_refuse_reason <=", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonLike(String value) {
            addCriterion("maxtp_refuse_reason like", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonNotLike(String value) {
            addCriterion("maxtp_refuse_reason not like", value, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonIn(List<String> values) {
            addCriterion("maxtp_refuse_reason in", values, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonNotIn(List<String> values) {
            addCriterion("maxtp_refuse_reason not in", values, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonBetween(String value1, String value2) {
            addCriterion("maxtp_refuse_reason between", value1, value2, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andMaxtpRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("maxtp_refuse_reason not between", value1, value2, "maxtpRefuseReason");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeIsNull() {
            addCriterion("sys_create_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeIsNotNull() {
            addCriterion("sys_create_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeEqualTo(Date value) {
            addCriterion("sys_create_refund_time =", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeNotEqualTo(Date value) {
            addCriterion("sys_create_refund_time <>", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeGreaterThan(Date value) {
            addCriterion("sys_create_refund_time >", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_create_refund_time >=", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeLessThan(Date value) {
            addCriterion("sys_create_refund_time <", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_create_refund_time <=", value, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeIn(List<Date> values) {
            addCriterion("sys_create_refund_time in", values, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeNotIn(List<Date> values) {
            addCriterion("sys_create_refund_time not in", values, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeBetween(Date value1, Date value2) {
            addCriterion("sys_create_refund_time between", value1, value2, "sysCreateRefundTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_create_refund_time not between", value1, value2, "sysCreateRefundTime");
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