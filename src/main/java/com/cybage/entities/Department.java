package com.cybage.entities;




import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="departments")
public class Department {
	
	@Transient
	public static final String SEQUENCE_NAME="department_sequence";

	@Id
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
