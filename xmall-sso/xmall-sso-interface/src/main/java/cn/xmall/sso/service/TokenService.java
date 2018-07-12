package cn.xmall.sso.service;

import cn.xmall.common.utils.XmallResult;

/**
 * 根据token查询用户信息
 * @author Jiang
 * @project XMALL
 *
 * 2018年6月18日
 */
public interface TokenService {

	XmallResult getUserByToken(String token);
	XmallResult logoutByToken(String token);
}
