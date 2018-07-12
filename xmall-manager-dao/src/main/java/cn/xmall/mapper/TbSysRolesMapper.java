package cn.xmall.mapper;

import cn.xmall.pojo.TbSysRoles;
import cn.xmall.pojo.TbSysRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRolesMapper {
    int countByExample(TbSysRolesExample example);

    int deleteByExample(TbSysRolesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSysRoles record);

    int insertSelective(TbSysRoles record);

    List<TbSysRoles> selectByExample(TbSysRolesExample example);

    TbSysRoles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSysRoles record, @Param("example") TbSysRolesExample example);

    int updateByExample(@Param("record") TbSysRoles record, @Param("example") TbSysRolesExample example);

    int updateByPrimaryKeySelective(TbSysRoles record);

    int updateByPrimaryKey(TbSysRoles record);
}