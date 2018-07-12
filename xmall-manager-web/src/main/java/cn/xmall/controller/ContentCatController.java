package cn.xmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.pojo.EasyUITreeNode;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.content.service.ContentCategoryService;

/**
 * 内容分类管理Controller
 * 
 * @author Jiang
 * @project XMALL
 *
 *          2018年6月17日
 */
@Controller
public class ContentCatController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
		List<EasyUITreeNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
	}

	/**
	 * 添加分类节点
	 */
	@RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult createContentCategory(Long parentId, String name) {
		// 调用服务添加节点
		XmallResult xmallResult = contentCategoryService.addContentCategory(parentId, name);
		return xmallResult;
	}

	/**
	 * 更新分类节点
	 */
	@RequestMapping(value = "/content/category/update", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult updateContentCategory(Long id, String name) {
		// 调用服务添加节点
		XmallResult xmallResult = contentCategoryService.updateContentCategory(id, name);
		return xmallResult;
	}

	/**
	 * 删除分类节点
	 */
	@RequestMapping(value = "/content/category/delete", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult deleteContentCategory(Long id) {
		// 调用服务添加节点
		XmallResult xmallResult = contentCategoryService.deleteContentCategory(id);
		return xmallResult;
	}
}
