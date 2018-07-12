package cn.xmall.cart.service;

import java.util.List;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbItem;

public interface CartService {

	XmallResult addCart(long userId, long itemId, int num);
	XmallResult mergeCart(long userId, List<TbItem> itemList);
	List<TbItem> getCartList(long userId);
	XmallResult updateCartNum(long userId, long itemId, int num);
	XmallResult deleteCartItem(long userId, long itemId);
	XmallResult clearCartItem(long userId);
}
