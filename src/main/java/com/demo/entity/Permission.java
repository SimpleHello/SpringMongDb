package com.demo.entity;

import java.util.List;

import com.demo.common.IEntity;

public class Permission  extends IEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8095915721286328248L;
	
	private String permName ;
    private String permCode ;
    private String permPath ;
    private Byte permType ;         //权限类型 0一级菜单 1二级菜单 2功能菜单(功能菜单可以没有路径)
    private Integer orderNo ;      //菜单排序号，关系用户登录时候，关系到首页显示具体哪个菜单
    private Permission parent ;
    private List<Role> roles ;
    
    public Permission(){}
    
    public Permission(String permName,String permCode){
    	this.permName = permName;
    	this.permCode = permCode;
    }
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermCode() {
		return permCode;
	}
	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}
	public String getPermPath() {
		return permPath;
	}
	public void setPermPath(String permPath) {
		this.permPath = permPath;
	}
	public Byte getPermType() {
		return permType;
	}
	public void setPermType(Byte permType) {
		this.permType = permType;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Permission getParent() {
		return parent;
	}
	public void setParent(Permission parent) {
		this.parent = parent;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	} 
    
    
    
}
