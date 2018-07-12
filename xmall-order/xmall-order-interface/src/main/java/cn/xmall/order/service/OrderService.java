package cn.xmall.order.service;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.order.pojo.OrderInfo;

public interface OrderService {

	XmallResult createOrder(OrderInfo orderInfo);
}
