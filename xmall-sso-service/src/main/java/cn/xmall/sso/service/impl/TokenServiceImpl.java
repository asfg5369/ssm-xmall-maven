package cn.xmall.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.xmall.common.jedis.JedisClient;
import cn.xmall.common.utils.JsonUtils;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbUser;
import cn.xmall.sso.service.TokenService;

/**
 * 根据token取用户信息
 * @author Jiang
 * @project XMALL
 *
 * 2018年6月18日
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public XmallResult  getUserByToken(String token) {
		//根据token到redis中取用户信息
		String json = jedisClient.get("SESSION:" + token);
		//取不到用户信息，登录已经过期，返回登录过期
		if (StringUtils.isBlank(json)) {
			return XmallResult.build(201, "用户登录已经过期");
		}
		//取到用户信息更新token的过期时间
		jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
		//返回结果，XmallResult 其中包含TbUser对象
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		return XmallResult.ok(user);
	}

	@Override
	public XmallResult logoutByToken(String token) {
		//删除token
		Long res = jedisClient.del("SESSION:" + token);
		if(res==1) {
			return XmallResult.build(200, "删除成功!");
		}else {
			return XmallResult.build(201, "删除失败!");
		}
		
	}

}
