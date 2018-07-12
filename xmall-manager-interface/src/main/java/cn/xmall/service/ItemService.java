package cn.xmall.service;

import cn.xmall.common.pojo.EasyUIDataGridResult;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbItem;
import cn.xmall.pojo.TbItemDesc;

public interface ItemService {
	// 商品页和详情页
	TbItem getItemById(long itemId);

	TbItemDesc getItemDescById(long itemId);

	EasyUIDataGridResult getItemList(int page, int rows);

	XmallResult addItem(TbItem item, String desc);

	/**
	 * 商品下架
	 */
	XmallResult dropoffItem(long[] itemId, TbItem item);

	/**
	 * 商品上架
	 */
	XmallResult upperoffItem(long[] itemId, TbItem item);

	/**
	 * 商品删除
	 */
	XmallResult deleteGoodsByItemIds(long[] itemIds);
}