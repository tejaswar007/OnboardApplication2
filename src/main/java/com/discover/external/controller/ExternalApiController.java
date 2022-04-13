package com.discover.external.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.discover.external.entity.Employee;
import com.discover.external.service.ExternalApiCallUsingFiegn;
import com.discover.external.service.ExternalServiceApiImpl;

@RestController
@Validated
@RequestMapping(value = "/person")
public class ExternalApiController {

	@Autowired
	ExternalServiceApiImpl externalServiceApiImpl;
	@Autowired
	ExternalApiCallUsingFiegn externalApiCallUsingFiegn;
	@Autowired
	private WebClient.Builder webBuilder;
	
	
	@GetMapping("/fetch/{personId}")
	public ResponseEntity<Double> fetchEmployee(@PathVariable  Long personId) {
		Employee employee = webBuilder.build().get()		
		.uri("http://localhost:8061/employee/fetchEmployee/"+personId)
		.retrieve()
		.bodyToMono(Employee.class)
		.block();
		return new ResponseEntity<Double>(employee.getEmployeeSalary(),HttpStatus.FOUND);
	}
	
	@GetMapping("/fetchAlternate/{personId}")
	public ResponseEntity<String> fetchEmployeeUsingFeign(@PathVariable  Long personId) throws IOException {
		Optional<Employee> employee  = externalApiCallUsingFiegn.getEmployeeDetails(personId);
		String convResp = employee.get().getEmployeeName();
		return new ResponseEntity<String>(convResp,HttpStatus.FOUND);
	}
	
	
}
