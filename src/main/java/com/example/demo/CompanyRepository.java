package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	@Modifying
    @Query("Select Contact from Company C WHERE c.name = :name")
    Iterable<Contact> getAllContacts(@Param("name") String name);

}
