package nl.palmapps.myawesomeproject.model;

public class LoginResult {

	private boolean success = false;
	private String tokenKey = "";

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
		success = true;
	}
	
	public String getTokenKey() {
		return tokenKey;
	}
	
	public boolean isSuccess() {
		return success;
	}
}
