package cn.xmall.mapper;

import cn.xmall.pojo.TbSysRolesPermissionsExample;
import cn.xmall.pojo.TbSysRolesPermissionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRolesPermissionsMapper {
    int countByExample(TbSysRolesPermissionsExample example);

    int deleteByExample(TbSysRolesPermissionsExample example);

    int deleteByPrimaryKey(TbSysRolesPermissionsKey key);

    int insert(TbSysRolesPermissionsKey record);

    int insertSelective(TbSysRolesPermissionsKey record);

    List<TbSysRolesPermissionsKey> selectByExample(TbSysRolesPermissionsExample example);

    int updateByExampleSelective(@Param("record") TbSysRolesPermissionsKey record, @Param("example") TbSysRolesPermissionsExample example);

    int updateByExample(@Param("record") TbSysRolesPermissionsKey record, @Param("example") TbSysRolesPermissionsExample example);
}