package jp.co.solidcom.security;

public class Constants {
	public static final String SECRET = "himitsukagidesuyo";
	public static final long EXPIRATION_TIME = 28800000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGNUP_URL = "/user/signup";
	public static final String LOGIN_URL = "/user/login";
	public static final String LOGIN_ID = "userId";
	public static final String PASSWORD = "password";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "devglan123r";
}
