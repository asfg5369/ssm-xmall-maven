package com.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ssm.mapper.PermissionsMapper;
import com.ssm.pojo.Permissions;
import com.ssm.service.IPermissionsService;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author Jiang
 * @since 2018-06-26
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {
	
}
