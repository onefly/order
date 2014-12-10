package com.qianqian.apply.mapper;

import com.qianqian.apply.model.ApplyCount;
import com.qianqian.apply.model.ApplyCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyCountMapper {
    int countByExample(ApplyCountExample example);

    int deleteByExample(ApplyCountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplyCount record);

    int insertSelective(ApplyCount record);

    List<ApplyCount> selectByExample(ApplyCountExample example);

    ApplyCount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplyCount record, @Param("example") ApplyCountExample example);

    int updateByExample(@Param("record") ApplyCount record, @Param("example") ApplyCountExample example);

    int updateByPrimaryKeySelective(ApplyCount record);

    int updateByPrimaryKey(ApplyCount record);
    
    int updateApplyNum(ApplyCount record);
}