package cn.xmall.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.utils.CookieUtils;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.sso.service.LoginService;

/**
 * 用户登录处理
 * @author Jiang
 * @project XMALL
 *
 * 2018年6月20日
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;

	@RequestMapping("/page/login")
	public String showLogin(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		XmallResult xmallResult = loginService.userLogin(username, password);
		// 判断是否登录成功
		if (xmallResult.getStatus() == 200) {
			String token = xmallResult.getData().toString();
			// 如果登录成功需要把token写入cookie
			CookieUtils.setCookie(request, response, TOKEN_KEY, token);
		}
		// 返回结果
		return xmallResult;
	}
}
