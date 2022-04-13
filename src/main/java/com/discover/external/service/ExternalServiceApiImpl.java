package com.discover.external.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.discover.external.entity.Person;
import lombok.RequiredArgsConstructor;
import com.discover.external.dao.ExternalServiceApiRepository;

@Service
@RequiredArgsConstructor
public class ExternalServiceApiImpl implements ExternalApiService{

	@Autowired
	private ExternalServiceApiRepository externalServiceApiRepository;
	
	@Override
	public Optional<Person> getPersonDetails(Long personId) {
		return externalServiceApiRepository.findById(personId);
	}

}
