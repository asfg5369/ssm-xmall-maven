package cn.xmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xmall.pojo.TbSysMenu;
import cn.xmall.pojo.TbSysMenuExample;

public interface TbSysMenuMapper {
	int countByExample(TbSysMenuExample example);

	int deleteByExample(TbSysMenuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbSysMenu record);

	int insertSelective(TbSysMenu record);

	List<TbSysMenu> selectByExample(TbSysMenuExample example);

	TbSysMenu selectByPrimaryKey(Long id);

	List<TbSysMenu> findAllRecursion();

	int updateByExampleSelective(@Param("record") TbSysMenu record, @Param("example") TbSysMenuExample example);

	int updateByExample(@Param("record") TbSysMenu record, @Param("example") TbSysMenuExample example);

	int updateByPrimaryKeySelective(TbSysMenu record);

	int updateByPrimaryKey(TbSysMenu record);
}