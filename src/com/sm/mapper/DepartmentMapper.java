package com.sm.mapper;

import java.util.List;

import com.sm.entity.Department;

public interface DepartmentMapper {

	public List<Department> findAllDepartment();//查询所有部门

	public void insertDepartment(Department department);

	public void delDepartmentById(Integer toid);

	public Department findDepartmentById(Integer toid);//通过部门id(toid)查询所有部门 

	public void updateDepartmentById(Department department);

}
