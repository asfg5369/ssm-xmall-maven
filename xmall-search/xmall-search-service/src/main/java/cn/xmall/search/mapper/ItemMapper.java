package cn.xmall.search.mapper;

import java.util.List;

import cn.xmall.common.pojo.SearchItem;

public interface ItemMapper {

	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);
}
