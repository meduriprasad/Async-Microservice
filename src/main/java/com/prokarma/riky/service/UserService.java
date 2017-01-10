package com.prokarma.riky.service;

import java.util.Optional;

import com.prokarma.riky.model.MobileInternet;
import com.prokarma.riky.model.User;

public interface UserService {
	public User getUserData(String user, String password);
	
	public Optional<MobileInternet> getUserMi(String msisdn);
	
}
