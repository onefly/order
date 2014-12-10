package com.qianqian.apply.mapper;

import com.qianqian.apply.model.ApplyHandleLog;
import com.qianqian.apply.model.ApplyHandleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyHandleLogMapper {
    int countByExample(ApplyHandleLogExample example);

    int deleteByExample(ApplyHandleLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplyHandleLog record);

    int insertSelective(ApplyHandleLog record);

    List<ApplyHandleLog> selectByExample(ApplyHandleLogExample example);

    ApplyHandleLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplyHandleLog record, @Param("example") ApplyHandleLogExample example);

    int updateByExample(@Param("record") ApplyHandleLog record, @Param("example") ApplyHandleLogExample example);

    int updateByPrimaryKeySelective(ApplyHandleLog record);

    int updateByPrimaryKey(ApplyHandleLog record);
}