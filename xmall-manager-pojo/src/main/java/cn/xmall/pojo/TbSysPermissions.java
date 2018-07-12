package cn.xmall.pojo;

import java.io.Serializable;

public class TbSysPermissions implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 202L;

	private Long id;

    private String permission;

    private String description;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}