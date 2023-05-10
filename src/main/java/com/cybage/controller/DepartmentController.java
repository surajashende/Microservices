package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.Department;
import com.cybage.service.DepartmentService;
import com.cybage.service.SequenceGenaratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private SequenceGenaratorService sequenceGenaratorService;
	
	@PostMapping("/")
	public Department saveDepartmenet(@RequestBody Department department) {
		department.setDepartmentId(sequenceGenaratorService.generateSequence(Department.SEQUENCE_NAME));
		log.info("department is added");
		return departmentService.saveDepartmenet(department);
	}
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("get Department");
		return departmentService.getDepartmentById(departmentId);
	}
	@PostMapping("/updateDepartment/{id}")
	public Department updateDepartment(@PathVariable("id") long departmentId,@RequestBody Department department) {
		Department updateDepartment=departmentService.getDepartmentById(departmentId);
		updateDepartment.setDepartmentName(department.getDepartmentName());
		updateDepartment.setDepartmentAddress(department.getDepartmentAddress());
		updateDepartment.setDepartmentCode(department.getDepartmentCode());
		return this.departmentService.saveDepartmenet(updateDepartment);
	}
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable("id") long departmentId) {
		Department department=this.departmentService.getDepartmentById(departmentId);
		this.departmentService.deleteDepartment(department);
		return "Record is deleted";
	}

}
