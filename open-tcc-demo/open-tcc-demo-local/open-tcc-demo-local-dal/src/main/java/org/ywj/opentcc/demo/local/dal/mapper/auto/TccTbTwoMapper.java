package org.ywj.opentcc.demo.local.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwo;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwoExample;

public interface TccTbTwoMapper {
    int countByExample(TccTbTwoExample example);

    int deleteByExample(TccTbTwoExample example);

    int deleteByPrimaryKey(Integer t2Id);

    int insert(TccTbTwo record);

    int insertSelective(TccTbTwo record);

    List<TccTbTwo> selectByExample(TccTbTwoExample example);

    TccTbTwo selectByPrimaryKey(Integer t2Id);

    int updateByExampleSelective(@Param("record") TccTbTwo record, @Param("example") TccTbTwoExample example);

    int updateByExample(@Param("record") TccTbTwo record, @Param("example") TccTbTwoExample example);

    int updateByPrimaryKeySelective(TccTbTwo record);

    int updateByPrimaryKey(TccTbTwo record);
}