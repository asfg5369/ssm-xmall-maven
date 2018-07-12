package cn.xmall.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.xmall.pojo.TbSysUsers;
import cn.xmall.pojo.TbSysUsersExample;

public interface TbSysUsersMapper {
	int countByExample(TbSysUsersExample example);

	int deleteByExample(TbSysUsersExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbSysUsers record);

	int insertSelective(TbSysUsers record);

	List<TbSysUsers> selectByExample(TbSysUsersExample example);

	TbSysUsers selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbSysUsers record, @Param("example") TbSysUsersExample example);

	int updateByExample(@Param("record") TbSysUsers record, @Param("example") TbSysUsersExample example);

	int updateByPrimaryKeySelective(TbSysUsers record);

	int updateByPrimaryKey(TbSysUsers record);

	// 通过用户名查询
	TbSysUsers findByUsername(@Param("username") String username);

	Set<String> findRoles(Long id);

	Set<String> findPermissions(Long id);
}