package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	 @Modifying
	    @Query("UPDATE Contact c SET c.name = :name WHERE c.email = :email")
	    int updateAddress(@Param("email") String email, @Param("name") String name);
}
