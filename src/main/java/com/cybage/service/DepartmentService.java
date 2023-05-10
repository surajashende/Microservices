package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.entities.Department;
import com.cybage.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartmenet(Department department) {
		return this.departmentRepository.save(department);
	}

	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.findBydepartmentId(departmentId);		
	}

	public void deleteDepartment(Department department) {
	   departmentRepository.delete(department);	
	}	
}
