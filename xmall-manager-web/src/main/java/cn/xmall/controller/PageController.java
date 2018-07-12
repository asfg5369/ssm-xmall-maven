package cn.xmall.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.pojo.TbSysMenu;
import cn.xmall.service.SysUserService;

/**
 * 
 * @author Jiang
 * @project XMALL
 *
 *          2018年6月14日
 */
@Controller
public class PageController {
	@Autowired
	private SysUserService userService;

	// 后台首页
	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		HttpSession session = request.getSession();
		session.setAttribute("name", userService.findByUsername(subject.getPrincipal().toString()).getAliasname());
		//菜单列表
		List<TbSysMenu> menuList = userService.findAllRecursion();
		model.addAttribute("list", menuList);
		return "index";
	}

	@RequestMapping("/loginValify")
	@ResponseBody
	public Map<String, Object> loginValify(Model model, HttpServletRequest request) {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(false);
			subject.login(token);
			// System.out.println("roles:"+subject.hasRole("admin"));
			System.out.println("------------------身份认证成功-------------------");
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功！");
		} catch (ExcessiveAttemptsException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "重试失败5次,10分钟后请再试!");
		} catch (AccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "账号或密码错误!");
		} catch (AuthenticationException e) {
			System.out.println(e);
			resultMap.put("status", 500);
			resultMap.put("message", "身份认证失败！");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "未知错误！");
		}
		return resultMap;
	}

	/**
	 * 退出
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		request.getSession().removeAttribute("name");
		return "login";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
