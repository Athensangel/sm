package com.sm.service;

import java.util.List;

import com.sm.entity.Department;

public interface DepartmentService {
	public List<Department> findAllDepartment();//遍历查询Department表中的字段

	public void saveDepartment(Department Department);//新增部门

	public void deletDepartmentById(Integer toid);//通过toId查找部门信息并做删除处理

	public Department queryDepartmentById(Integer toid);//通过toId查找部门信息并做删除处理

	public void updateDepartmentById(Department department);//查找部门，并修改部门信息
}
