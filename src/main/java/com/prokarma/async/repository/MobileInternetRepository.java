package com.prokarma.async.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prokarma.async.model.MobileInternet;

public interface MobileInternetRepository extends CrudRepository<MobileInternet, Integer> {
	@Query("select mi FROM MobileInternet mi INNER JOIN FETCH mi.user WHERE mi.user.msisdn = :username")
	public Optional<MobileInternet> findByUserName(@Param("username") String msisdn);
}
