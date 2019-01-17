package exceptions;


public class OnlyLettersException extends Exception{
	private static final long serialVersionUID = 1L;
	
	
	
	public OnlyLettersException() {
		getMessage();
	}
	
	public String getMessage() {
		return "Some Fields Must \nConatin Only Letters!";
	}


	

}
