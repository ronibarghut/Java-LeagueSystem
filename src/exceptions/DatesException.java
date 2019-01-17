package exceptions;

public class DatesException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public DatesException() {
	}
	
	@Override
	public String getMessage() {
		return "BirthDate must be earlier than startWorkingDate!";
	}

}
