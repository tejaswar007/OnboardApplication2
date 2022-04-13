package com.discover.external.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name  = "PersonDetails")
public class Person {
	@Id
	private String personId;
	@NotEmpty
	private String address;
	@NotEmpty
	private String mobileNumber;
}
