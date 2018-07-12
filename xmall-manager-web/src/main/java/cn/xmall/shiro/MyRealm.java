/**
 * 
 */
package cn.xmall.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.xmall.pojo.TbSysUsers;
import cn.xmall.service.SysUserService;

/**
 * @ClassName: MyRealm
 * @Description: shiro 认证 + 授权 重写
 */
public class MyRealm extends AuthorizingRealm {
	@Resource
	private SysUserService userService;
	/**
	 * 授权Realm
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		TbSysUsers user = userService.findByUsername(username);
		Long id = user.getId();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/** 根据用户ID查询角色（role），放入到Authorization里. */
		info.setRoles(userService.findRoles(id));
		/** 根据用户ID查询权限（permission），放入到Authorization里. */
		info.setStringPermissions(userService.findPermissions(id));
		return info;
	}

	/**
	 * 登录认证Realm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		String username = (String) token.getPrincipal();
		TbSysUsers user = userService.findByUsername(username);
		if (user == null) {
			throw new AccountException("帐号或密码不正确");
		}
		String password = user.getPassword();
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password,
				ByteSource.Util.bytes(user.getSalt()), getName());
		return authenticationInfo;
	}

}
