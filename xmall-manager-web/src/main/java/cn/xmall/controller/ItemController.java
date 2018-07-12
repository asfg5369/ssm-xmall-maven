package cn.xmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xmall.common.pojo.EasyUIDataGridResult;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbItem;
import cn.xmall.service.ItemService;

/**
 * 
 * @author Jiang
 * @project XMALL
 *
 *          2018年6月14日
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	/**
	 * 商品添加功能
	 */
	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	@ResponseBody
	public XmallResult addItem(TbItem item, String desc) {
		XmallResult result = itemService.addItem(item, desc);
		return result;
	}

	// 上架商品
	@RequestMapping(value = "/rest/item/reshelf", method = RequestMethod.POST)
	@ResponseBody
	private XmallResult upperoffItem(@RequestParam("ids") long[] itemId, TbItem item) {
		XmallResult result = itemService.upperoffItem(itemId, item);
		return result;
	}

	// 下架商品
	@RequestMapping(value = "/rest/item/instock", method = RequestMethod.POST)
	@ResponseBody
	private XmallResult dropoffItem(@RequestParam("ids") long[] itemId, TbItem item) {
		XmallResult result = itemService.dropoffItem(itemId, item);
		return result;
	}

	// 删除商品及其详细
	@RequestMapping(value = "/rest/item/delete", method = RequestMethod.POST)
	@ResponseBody
	private XmallResult dropoffItem(@RequestParam("ids") long[] itemIds) {
		XmallResult result = itemService.deleteGoodsByItemIds(itemIds);
		return result;
	}
}
