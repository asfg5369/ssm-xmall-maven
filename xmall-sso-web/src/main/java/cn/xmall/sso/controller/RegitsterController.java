package cn.xmall.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbUser;
import cn.xmall.sso.service.RegisterService;

/**
 * 注册功能Controller
 * 
 * @author Jiang
 * @project XMALL
 * 2018年6月18日
 */
@Controller
public class RegitsterController {
	@Autowired
	private RegisterService registerService;

	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}

	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public XmallResult checkData(@PathVariable String param, @PathVariable Integer type) {
		XmallResult xmallResult = registerService.checkData(param, type);
		return xmallResult;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult register(TbUser user) {
		XmallResult xmallResult = registerService.register(user);
		return xmallResult;
	}
}
