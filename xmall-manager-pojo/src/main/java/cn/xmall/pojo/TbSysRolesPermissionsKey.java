package cn.xmall.pojo;

import java.io.Serializable;

public class TbSysRolesPermissionsKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 204L;

	private Long roleId;

    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}