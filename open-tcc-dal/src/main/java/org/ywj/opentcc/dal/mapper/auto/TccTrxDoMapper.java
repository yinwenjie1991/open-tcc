package org.ywj.opentcc.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ywj.opentcc.dal.entity.TccTrxDo;
import org.ywj.opentcc.dal.entity.TccTrxDoExample;

public interface TccTrxDoMapper {
    int countByExample(TccTrxDoExample example);

    int deleteByExample(TccTrxDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TccTrxDo record);

    int insertSelective(TccTrxDo record);

    List<TccTrxDo> selectByExampleWithBLOBs(TccTrxDoExample example);

    List<TccTrxDo> selectByExample(TccTrxDoExample example);

    TccTrxDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TccTrxDo record, @Param("example") TccTrxDoExample example);

    int updateByExampleWithBLOBs(@Param("record") TccTrxDo record, @Param("example") TccTrxDoExample example);

    int updateByExample(@Param("record") TccTrxDo record, @Param("example") TccTrxDoExample example);

    int updateByPrimaryKeySelective(TccTrxDo record);

    int updateByPrimaryKeyWithBLOBs(TccTrxDo record);

    int updateByPrimaryKey(TccTrxDo record);
}