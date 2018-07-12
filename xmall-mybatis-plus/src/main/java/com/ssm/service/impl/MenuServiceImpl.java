package com.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ssm.mapper.MenuMapper;
import com.ssm.pojo.Menu;
import com.ssm.service.IMenuService;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author Jiang
 * @since 2018-06-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	
}
