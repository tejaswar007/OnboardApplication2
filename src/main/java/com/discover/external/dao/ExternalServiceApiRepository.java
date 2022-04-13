package com.discover.external.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.discover.external.entity.Person;

@Repository
public interface ExternalServiceApiRepository extends JpaRepository<Person, Long>{

}
