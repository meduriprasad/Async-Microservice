package com.prokarma.async.repository;

import org.springframework.data.repository.CrudRepository;

import com.prokarma.async.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findOneByMsisdn(String msisdn);
}
