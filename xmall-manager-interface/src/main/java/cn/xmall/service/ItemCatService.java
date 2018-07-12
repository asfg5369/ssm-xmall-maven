package cn.xmall.service;

import java.util.List;

import cn.xmall.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	List<EasyUITreeNode> getItemCatlist(long parentId);
}
