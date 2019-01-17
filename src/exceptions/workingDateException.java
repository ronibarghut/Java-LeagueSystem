package exceptions;

public class workingDateException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public workingDateException() {
	}
	
	@Override
	public String getMessage() {
		return "startWorkingDate must be before today!";
	}

}
