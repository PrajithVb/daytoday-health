package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Organization;
@Repository
public interface OrgRepository extends MongoRepository<Organization, String> {

	
	public Organization findByName(String name);
	
}
