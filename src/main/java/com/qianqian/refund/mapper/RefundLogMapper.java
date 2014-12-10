package com.qianqian.refund.mapper;

import com.qianqian.refund.model.RefundLog;
import com.qianqian.refund.model.RefundLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundLogMapper {
    int countByExample(RefundLogExample example);

    int deleteByExample(RefundLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundLog record);

    int insertSelective(RefundLog record);

    List<RefundLog> selectByExample(RefundLogExample example);

    RefundLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundLog record, @Param("example") RefundLogExample example);

    int updateByExample(@Param("record") RefundLog record, @Param("example") RefundLogExample example);

    int updateByPrimaryKeySelective(RefundLog record);

    int updateByPrimaryKey(RefundLog record);
}