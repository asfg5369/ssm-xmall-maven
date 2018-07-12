package cn.xmall.content.service;

import java.util.List;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbContent;

public interface ContentService {

	XmallResult addContent(TbContent content);

	//首页查询所有
	List<TbContent> getContentListByCid(long cid);

	// 查询分类列表所有
	List<TbContent> getContentListByCategoryId(long categoryId, int page, int rows);
}
