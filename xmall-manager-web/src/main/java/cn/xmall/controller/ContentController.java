package cn.xmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.content.service.ContentService;
import cn.xmall.pojo.TbContent;

/**
 * 内容管理Controller
 * 
 * @author Jiang
 * @project XMALL
 *
 *          2018年6月17日
 */
@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	// 添加内容
	@RequestMapping(value = "/content/save", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult addContent(TbContent content) {
		// 调用服务把内容数据保存到数据库
		XmallResult xmallResult = contentService.addContent(content);
		return xmallResult;
	}

	// 查询分类列列表
	@RequestMapping(value = "/content/query/list")
	@ResponseBody
	public List<TbContent> queryContentList(Long categoryId, int page, int rows) {
		List<TbContent> list = contentService.getContentListByCategoryId(categoryId, page, rows);
		return list;
	}
	
}
