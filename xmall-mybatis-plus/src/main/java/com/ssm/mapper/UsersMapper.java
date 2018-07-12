package com.ssm.mapper;

import com.ssm.pojo.Users;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author Jiang
 * @since 2018-06-26
 */
public interface UsersMapper extends BaseMapper<Users> {

	List<Users> selectAllDesc();
}