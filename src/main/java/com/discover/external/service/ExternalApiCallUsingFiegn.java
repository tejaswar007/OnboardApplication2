package com.discover.external.service;

import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.discover.external.entity.Employee;

@FeignClient(value="employee", url = "http://localhost:8061")
public interface ExternalApiCallUsingFiegn {

	@GetMapping("employee/fetchEmployee/{personId}")
	Optional<Employee> getEmployeeDetails(@PathVariable("personId") Long personId);
	
}
