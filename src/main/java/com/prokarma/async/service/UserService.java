package com.prokarma.async.service;

import java.util.Optional;

import com.prokarma.async.model.MobileInternet;
import com.prokarma.async.model.User;

public interface UserService {
	public User getUserData(String user, String password);
	
	public Optional<MobileInternet> getUserMi(String msisdn);
	
}
