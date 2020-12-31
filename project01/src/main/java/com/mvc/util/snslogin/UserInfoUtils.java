package com.mvc.util.snslogin;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserInfoUtils {
	
	public String makeDistinctString(String id, String email) throws NoSuchAlgorithmException {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
