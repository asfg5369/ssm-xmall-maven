package cn.xmall.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xmall.mapper.TbSysMenuMapper;
import cn.xmall.mapper.TbSysUsersMapper;
import cn.xmall.pojo.TbSysMenu;
import cn.xmall.pojo.TbSysUsers;
import cn.xmall.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private TbSysUsersMapper mapper;
	
	@Autowired
	private TbSysMenuMapper menuMapper;
	@Override
	public TbSysUsers findByUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(Long id) {
		// TODO Auto-generated method stub
		return mapper.findRoles(id);
	}

	@Override
	public Set<String> findPermissions(Long id) {
		// TODO Auto-generated method stub
		return mapper.findPermissions(id);
	}

	@Override
	public List<TbSysMenu> findAllRecursion() {
		// TODO Auto-generated method stub
		return menuMapper.findAllRecursion();
	}

}
