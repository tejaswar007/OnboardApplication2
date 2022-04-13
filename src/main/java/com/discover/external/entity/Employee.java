package com.discover.external.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Employee {	@Id
	private Long employeeId;
	@NotEmpty
	private String employeeName;
	@NotNull
	private  Double employeeSalary;
}
