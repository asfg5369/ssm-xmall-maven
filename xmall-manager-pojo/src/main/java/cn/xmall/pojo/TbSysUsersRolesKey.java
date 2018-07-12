package cn.xmall.pojo;

import java.io.Serializable;

public class TbSysUsersRolesKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 206L;

	private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}