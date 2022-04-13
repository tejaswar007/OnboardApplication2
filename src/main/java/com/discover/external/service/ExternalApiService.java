package com.discover.external.service;

import java.util.Optional;

import com.discover.external.entity.Person;

public interface ExternalApiService {
	public Optional<Person> getPersonDetails(Long personId);

}
