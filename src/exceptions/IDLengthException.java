package exceptions;


public class IDLengthException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public IDLengthException() {
	}
	
	@Override
	public String getMessage() {
		return "Customer ID must be 9 digit length!";
	}

}
