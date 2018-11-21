package jp.co.solidcom.security;

public class JwtAuthenticationRequest {
	private String userId;
	private String password;

	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String userId, String password) {
		this.setUserId(userId);
		this.setPassword(password);
	}

	public String setUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
