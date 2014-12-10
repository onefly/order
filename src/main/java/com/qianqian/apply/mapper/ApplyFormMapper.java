package com.qianqian.apply.mapper;

import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.model.ApplyFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyFormMapper {
    int countByExample(ApplyFormExample example);

    int deleteByExample(ApplyFormExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplyForm record);

    int insertSelective(ApplyForm record);

    List<ApplyForm> selectByExample(ApplyFormExample example);

    ApplyForm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplyForm record, @Param("example") ApplyFormExample example);

    int updateByExample(@Param("record") ApplyForm record, @Param("example") ApplyFormExample example);

    int updateByPrimaryKeySelective(ApplyForm record);

    int updateByPrimaryKey(ApplyForm record);
    
    int updateSupportNum(long id);
    int updateStateByCrontab(ApplyForm apply);
}