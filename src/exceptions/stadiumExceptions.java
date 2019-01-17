package exceptions;

import Model.Stadium;

public class stadiumExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	private Stadium Stad;
	
	public stadiumExceptions(Stadium stadium) {
		setStadium(stadium); 
	}
	
	@Override
	public String getMessage() {
		return "General Stadium Exception:\n"
		       + getStadium().getId();
	}

	public Stadium getStadium() {
		return Stad;
	}
	
	public void setStadium(Stadium stadium) {
		this.Stad = stadium;
	}
	
}

