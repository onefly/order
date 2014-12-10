package com.qianqian.apply.mapper;

import com.qianqian.apply.model.ApplySupportRecord;
import com.qianqian.apply.model.ApplySupportRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplySupportRecordMapper {
    int countByExample(ApplySupportRecordExample example);

    int deleteByExample(ApplySupportRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplySupportRecord record);

    int insertSelective(ApplySupportRecord record);

    List<ApplySupportRecord> selectByExample(ApplySupportRecordExample example);

    ApplySupportRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplySupportRecord record, @Param("example") ApplySupportRecordExample example);

    int updateByExample(@Param("record") ApplySupportRecord record, @Param("example") ApplySupportRecordExample example);

    int updateByPrimaryKeySelective(ApplySupportRecord record);

    int updateByPrimaryKey(ApplySupportRecord record);
}