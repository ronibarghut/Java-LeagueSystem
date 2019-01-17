package exceptions;

public class custAlreadyRegToMatchException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public custAlreadyRegToMatchException() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nCustomer is already registered to this Match!";
	}

}
