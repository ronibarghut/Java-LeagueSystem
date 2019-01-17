package exceptions;

import Model.Stadium;

public class existingStadiumException extends stadiumExceptions {

	private static final long serialVersionUID = 1L;
	
	public existingStadiumException(Stadium stad) {
		super(stad);
	}
	
	@Override
	public String getMessage() {
		return "Failed to add Stadium:\n"
		+ super.getStadium().getId()	
        + "\nbecause this Stadium already exists!";
	}

}
