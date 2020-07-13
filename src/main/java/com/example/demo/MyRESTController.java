package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;
	
	@Autowired
	CompanyRepository companyRepo;

	@GetMapping("/contacts")
	public Iterable<Contact> getContacts() {
		return repository.findAll();
	}
	
	@PostMapping("/contacts/create")
	public void createContact(Contact contact)
	{
		repository.save(contact);
	}
	
	@PutMapping("/contacts/email/name")
	
	public int updateContact(@Param("email") String email, @Param("name") String name)
	{
		
		return repository.updateAddress(email, name);
	}
	
	@DeleteMapping("/contacts/delete")
	public void deleteContact(Contact contact)
	{
		repository.delete(contact);
	}
	
	@GetMapping("/contacts/company_name")
	public Iterable<Contact> getContactsByCompanyName(@Param("company_name") String name) {
		return companyRepo.getAllContacts(name);
	}
}
