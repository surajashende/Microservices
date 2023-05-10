package com.cybage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cybage.entities.Department;

public interface DepartmentRepository extends MongoRepository<Department, Long> {
	public Department findBydepartmentId(Long departmentId);

}
