package com.mvc.util.snslogin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NaverloginVO {
	
	private final static String CLIENT_ID = "mapbWLdATX8fqgVZ18kV";
	private final static String CLIENT_SECRET = "DZTcNLKrHs";
	private final static String REDIRECT_URI = "";
	private final static String SESSION_STATE = "oauth_state_n";
	
	//프로필 조회 API URL
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
	
	private Logger logger = LoggerFactory.getLogger(NaverloginVO.class);
	
	//네아로 인증 URL 생성 Method
	public String getAuthorizationUrl(HttpSession session) {
		
		//세션 유효성 검증을 위한 난수 생성 후 session에 저장
		String state = generateRandomString();
		
		
		return "";
	}

	public String generateRandomString() {
		
		return UUID.setA;
	}
	
	
	

}
