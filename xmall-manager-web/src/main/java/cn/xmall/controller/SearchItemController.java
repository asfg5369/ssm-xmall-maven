package cn.xmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.search.service.SearchItemService;

/**
 * 导入商品数据到索引库
 * @author Jiang
 * @project XMALL
 *
 * 2018年6月17日
 */
@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/item/import")
	@ResponseBody
	public XmallResult importItemList() {
		XmallResult xmallResult = searchItemService.importAllItems();
		return xmallResult;
		
	}
}
