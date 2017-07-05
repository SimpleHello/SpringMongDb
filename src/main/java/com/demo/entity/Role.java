package com.demo.entity;

import java.util.Date;
import java.util.List;

import com.demo.common.IEntity;

public class Role extends IEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 304340613044767686L;

	private String roleName ;
    private String roleDesc ;
    private Byte isDeleted ;
    private boolean isManager ;
    private Date createTime ;
    private List<Permission> permissions ;
    private List<User> users ;
    
    public Role(){}
    
    public Role(String roleName){
    	this.roleName = roleName;
    }
    
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
    
    
    
}
