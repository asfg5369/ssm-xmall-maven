package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ssm.mapper.UsersMapper;
import com.ssm.pojo.Users;
import com.ssm.service.IUsersService;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author Jiang
 * @since 2018-06-26
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
	@Autowired
	private UsersMapper mapper;

	@Override
	public List<Users> selectAllDesc() {
		return mapper.selectAllDesc();
	}

}
