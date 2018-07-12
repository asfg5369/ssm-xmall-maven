package cn.xmall.service;

import java.util.List;
import java.util.Set;

import cn.xmall.pojo.TbSysMenu;
import cn.xmall.pojo.TbSysUsers;
//后台
public interface SysUserService {
	TbSysUsers findByUsername(String username);

	Set<String> findRoles(Long id);

	Set<String> findPermissions(Long id);
	
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<TbSysMenu> findAllRecursion();
}
