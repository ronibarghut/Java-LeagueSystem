package exceptions;

public class alreadyCoachException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public alreadyCoachException() {
	}
	
	@Override
	public String getMessage() {
		return "This employee is already the coach\nof this team!";
	}

}
