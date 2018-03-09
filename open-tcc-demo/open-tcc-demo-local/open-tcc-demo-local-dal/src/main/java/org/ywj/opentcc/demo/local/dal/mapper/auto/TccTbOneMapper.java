package org.ywj.opentcc.demo.local.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOne;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOneExample;

public interface TccTbOneMapper {
    int countByExample(TccTbOneExample example);

    int deleteByExample(TccTbOneExample example);

    int deleteByPrimaryKey(Integer t1Id);

    int insert(TccTbOne record);

    int insertSelective(TccTbOne record);

    List<TccTbOne> selectByExample(TccTbOneExample example);

    TccTbOne selectByPrimaryKey(Integer t1Id);

    int updateByExampleSelective(@Param("record") TccTbOne record, @Param("example") TccTbOneExample example);

    int updateByExample(@Param("record") TccTbOne record, @Param("example") TccTbOneExample example);

    int updateByPrimaryKeySelective(TccTbOne record);

    int updateByPrimaryKey(TccTbOne record);
}