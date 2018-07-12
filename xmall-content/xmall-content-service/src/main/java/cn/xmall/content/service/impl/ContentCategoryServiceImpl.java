package cn.xmall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xmall.common.pojo.EasyUITreeNode;
import cn.xmall.common.utils.XmallResult;
import cn.xmall.content.service.ContentCategoryService;
import cn.xmall.mapper.TbContentCategoryMapper;
import cn.xmall.pojo.TbContentCategory;
import cn.xmall.pojo.TbContentCategoryExample;
import cn.xmall.pojo.TbContentCategoryExample.Criteria;

/**
 * 内容分类管理Service
 * 
 * @author Jiang
 * @project XMALL
 *
 *          2018年6月17日
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCatList(long parentId) {
		// 根据parentid查询子节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbContentCategory> catList = contentCategoryMapper.selectByExample(example);
		// 转换成EasyUITreeNode的列表
		List<EasyUITreeNode> nodeList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : catList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			// 添加到列表
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public XmallResult addContentCategory(long parentId, String name) {
		// 创建一个tb_content_category表对应的pojo对象
		TbContentCategory contentCategory = new TbContentCategory();
		// 设置pojo的属性
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		// 1(正常),2(删除)
		contentCategory.setStatus(1);
		// 默认排序就是1
		contentCategory.setSortOrder(1);
		// 新添加的节点一定是叶子节点
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 插入到数据库
		contentCategoryMapper.insert(contentCategory);
		// 判断父节点的isparent属性。如果不是true改为true
		// 根据parentid查询父节点
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parent.getIsParent()) {
			parent.setIsParent(true);
			// 更新到数数据库
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		// 返回结果，返回E3Result，包含pojo
		return XmallResult.ok(contentCategory);
	}

	/**
	 * 更新
	 */
	@Override
	public XmallResult updateContentCategory(long id, String name) {
		// 创建一个tb_content_category表对应的pojo对象
		TbContentCategory contentCategory = new TbContentCategory();
		// 设置pojo的属性
		contentCategory.setId(id);
		contentCategory.setName(name);
		int result = contentCategoryMapper.updateByPrimaryKey(contentCategory);
		if (result == 1) {
			return XmallResult.ok("删除成功!");
		} else {
			return XmallResult.ok("删除失败!");
		}
	}

	@Override
	public XmallResult deleteContentCategory(Long id) {
		int result = contentCategoryMapper.deleteByPrimaryKey(id);
		if (result == 1) {
			return XmallResult.ok("删除成功!");
		} else {
			return XmallResult.ok("删除失败!");
		}
	}

}
