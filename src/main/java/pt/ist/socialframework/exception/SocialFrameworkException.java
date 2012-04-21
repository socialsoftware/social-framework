package pt.ist.socialframework.exception;

public class SocialFrameworkException extends Exception {

	private String msg;

	public SocialFrameworkException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
