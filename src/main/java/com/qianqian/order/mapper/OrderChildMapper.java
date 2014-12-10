package com.qianqian.order.mapper;

import com.qianqian.order.model.OrderChild;
import com.qianqian.order.model.OrderChildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderChildMapper {
    int countByExample(OrderChildExample example);

    int deleteByExample(OrderChildExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderChild record);

    int insertSelective(OrderChild record);

    List<OrderChild> selectByExample(OrderChildExample example);

    OrderChild selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderChild record, @Param("example") OrderChildExample example);

    int updateByExample(@Param("record") OrderChild record, @Param("example") OrderChildExample example);

    int updateByPrimaryKeySelective(OrderChild record);

    int updateByPrimaryKey(OrderChild record);
}