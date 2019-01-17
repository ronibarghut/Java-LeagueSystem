package exceptions;

import Model.Coach;

public class existingCoachException extends coachExceptions {

	private static final long serialVersionUID = 1L;
	
	public existingCoachException(Object coach) {
		super(coach);
	}
	
	@Override
	public String getMessage() {
		if(super.getObject() instanceof Coach){
		return "Error! Coach with ID:\n"
		+ ((Coach) super.getObject()).getId()	
        + "\nalready exists!";
		}
		
		return null;
	}

}
