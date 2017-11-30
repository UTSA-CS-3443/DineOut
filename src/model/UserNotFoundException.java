package model;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354020743470799220L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
