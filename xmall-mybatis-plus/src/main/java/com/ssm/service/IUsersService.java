package com.ssm.service;

import com.ssm.pojo.Users;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * @author Jiang
 * @since 2018-06-26
 */
public interface IUsersService extends IService<Users> {
	List<Users> selectAllDesc();
}
