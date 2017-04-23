package com.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.entity.Department;
import com.sm.mapper.DepartmentMapper;
import com.sm.service.DepartmentService;
/**
 * departmentMapper跟数据库打交道层
 * @author Administrator
 *
 */
@Transactional(readOnly=true)
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> findAllDepartment() {
		return departmentMapper.findAllDepartment();
	}

	@Transactional(readOnly=false)
	@Override
	public void saveDepartment(Department Department) {
		departmentMapper.insertDepartment(Department);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletDepartmentById(Integer toid) {
		departmentMapper.delDepartmentById(toid);
	}

	@Override
	public Department queryDepartmentById(Integer toid) {
		return departmentMapper.findDepartmentById(toid);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateDepartmentById(Department department) {
		departmentMapper.updateDepartmentById(department);
	}

}
