package com.qianqian.refund.mapper;

import com.qianqian.refund.model.Refund;
import com.qianqian.refund.model.RefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundMapper {
    int countByExample(RefundExample example);

    int deleteByExample(RefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Refund record);

    int insertSelective(Refund record);

    List<Refund> selectByExample(RefundExample example);

    Refund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Refund record, @Param("example") RefundExample example);

    int updateByExample(@Param("record") Refund record, @Param("example") RefundExample example);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}