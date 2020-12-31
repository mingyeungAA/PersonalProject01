package com.mvc.util.snslogin;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

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
		setSession(session, state);
		logger.info("\n[naver] * state : "+state+"\n* session state : "+getSession(session));
		
		//scribe에서 제공하는 인증 url 생성 기능을 이용하여 네아로 인증 url 생성
		OAuth20Service oauthService = new ServiceBuilder(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI)
				.build(NaverApi.instance());
		
		return oauthService.getAuthorizationUrl(state);
	}
	
	//네아로 callback 처리 및 access token 획득 method
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException, InterruptedException, ExecutionException{
		
		//callback으로 전달받은 세션 검증용 난수와 세션에 저장되어 있는 난수값 비교
		String sessionState = getSession(session);
		if(StringUtils.pathEquals(sessionState,  state)) {
			OAuth20Service oauthService = new ServiceBuilder(CLIENT_ID)
					.apiSecret(CLIENT_SECRET)
					.callback(REDIRECT_URI)
					.build(NaverApi.instance());
			return oauthService.getAccessToken(code);
		}
		return null;
	}
	
	//access tocken을 이용하여 네이버 사용자 프로필 api 호출
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException, InterruptedException, ExecutionException{
		
		OAuth20Service oauthService = new ServiceBuilder(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI)
				.build(NaverApi.instance());
		
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL);
		oauthService.signRequest(oauthToken, request);
		
		Response response = oauthService.execute(request);
		return response.getBody();
	}

	private String generateRandomString() {
		
		return UUID.randomUUID().toString();
	}
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}
	private String getSession(HttpSession session) {
		return (String)session.getAttribute(SESSION_STATE);
	}
	
	
	

}
