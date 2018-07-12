package cn.xmall.content.service;

import java.util.List;

import cn.xmall.common.pojo.EasyUITreeNode;
import cn.xmall.common.utils.XmallResult;

public interface ContentCategoryService {

	List<EasyUITreeNode> getContentCatList(long parentId);
	XmallResult addContentCategory(long parentId, String name);
	XmallResult updateContentCategory(long id, String name);
	XmallResult deleteContentCategory(Long id);
}
