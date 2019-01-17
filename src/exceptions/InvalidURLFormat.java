package exceptions;

public class InvalidURLFormat extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public InvalidURLFormat() {
	}
	
	@Override
	public String getMessage() {
		return "Invalid URL Format!\n URL Must be like: \nhttp://www.example.com/";
	}

}
