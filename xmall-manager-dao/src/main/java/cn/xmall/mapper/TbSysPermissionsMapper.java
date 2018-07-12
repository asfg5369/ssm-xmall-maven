package cn.xmall.mapper;

import cn.xmall.pojo.TbSysPermissions;
import cn.xmall.pojo.TbSysPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionsMapper {
    int countByExample(TbSysPermissionsExample example);

    int deleteByExample(TbSysPermissionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSysPermissions record);

    int insertSelective(TbSysPermissions record);

    List<TbSysPermissions> selectByExample(TbSysPermissionsExample example);

    TbSysPermissions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSysPermissions record, @Param("example") TbSysPermissionsExample example);

    int updateByExample(@Param("record") TbSysPermissions record, @Param("example") TbSysPermissionsExample example);

    int updateByPrimaryKeySelective(TbSysPermissions record);

    int updateByPrimaryKey(TbSysPermissions record);
}