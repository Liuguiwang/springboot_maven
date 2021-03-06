package com.wzu.lgw.appinfosystem.pojo;

import java.util.Date;

public class BackendUser {
	private Integer id;//主键id
	private String userCode;//用户编码（登录账号）
	private String userName;//用户名称
	private String userPassword;//用户密码
	private Integer userType;//用户角色类型id
	private Integer createdBy;//创建者
	private Date creationDate;//创建时间
	private Integer modifyBy;//更新者
	private Date modifyDate;//更新时间
	private String userTypeName;//用户角色类型名称
	
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

//	public BackendUser(String userCode, String userName, Integer userType, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate,String userPassword) {
//		this.userCode = userCode;
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.userType = userType;
//		this.createdBy = createdBy;
//		this.creationDate = creationDate;
//		this.modifyBy = modifyBy;
//		this.modifyDate = modifyDate;
//	}
//
//	public BackendUser(Integer id, String userCode, String userName, String userPassword, Integer userType, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate, String userTypeName) {
//		this.id = id;
//		this.userCode = userCode;
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.userType = userType;
//		this.createdBy = createdBy;
//		this.creationDate = creationDate;
//		this.modifyBy = modifyBy;
//		this.modifyDate = modifyDate;
//		this.userTypeName = userTypeName;
//	}


	@Override
	public String toString() {
		return "BackendUser{" +
				"id=" + id +
				", userCode='" + userCode + '\'' +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userType=" + userType +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				", userTypeName='" + userTypeName + '\'' +
				'}';
	}
}
