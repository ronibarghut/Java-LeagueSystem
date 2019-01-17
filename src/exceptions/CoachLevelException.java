package exceptions;

public class CoachLevelException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public CoachLevelException() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nCoach's level is lower than team's level!";
	}

}
