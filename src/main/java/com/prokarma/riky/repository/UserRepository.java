package com.prokarma.riky.repository;

import org.springframework.data.repository.CrudRepository;

import com.prokarma.riky.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findOneByMsisdn(String msisdn);
}
