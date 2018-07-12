package cn.xmall.order.pojo;

import java.io.Serializable;
import java.util.List;

import cn.xmall.pojo.TbOrder;
import cn.xmall.pojo.TbOrderItem;
import cn.xmall.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003L;
	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
}
