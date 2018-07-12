package cn.xmall.mapper;

import cn.xmall.pojo.TbSysUsersRolesExample;
import cn.xmall.pojo.TbSysUsersRolesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUsersRolesMapper {
    int countByExample(TbSysUsersRolesExample example);

    int deleteByExample(TbSysUsersRolesExample example);

    int deleteByPrimaryKey(TbSysUsersRolesKey key);

    int insert(TbSysUsersRolesKey record);

    int insertSelective(TbSysUsersRolesKey record);

    List<TbSysUsersRolesKey> selectByExample(TbSysUsersRolesExample example);

    int updateByExampleSelective(@Param("record") TbSysUsersRolesKey record, @Param("example") TbSysUsersRolesExample example);

    int updateByExample(@Param("record") TbSysUsersRolesKey record, @Param("example") TbSysUsersRolesExample example);
}