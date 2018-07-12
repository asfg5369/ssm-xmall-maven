package cn.xmall.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSysMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 201L;

	private Long id;

	private String name;

	private String url;
	private Long parentid;

	private String icon;
	// 子菜单
	private List<TbSysMenu> children;

	public List<TbSysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<TbSysMenu> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}
}