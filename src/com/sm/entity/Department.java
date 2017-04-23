package com.sm.entity;
/**
 * Department的实体类
 * @author Administrator
 *
 */
public class Department {
	public Integer toId;//主键，自动增长

	public String departmentName;//部门名称

	public Integer managerId;//部门经理，来自员工表

	public String userRealName;//部门经理员工表

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	/**
	 * settoString打印出去中文字符
	 */
	@Override
	public String toString() {
		return "Department [toId=" + toId + ", departmentName=" + departmentName + ", managerId=" + managerId
				+ ", userRealName=" + userRealName + "]";
	}
}
