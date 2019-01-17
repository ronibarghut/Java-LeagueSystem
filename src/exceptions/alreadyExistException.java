package exceptions;

import Model.Coach;
import Model.Customer;
import Model.Player;
import Model.Receptionist;
import Model.Stadium;
import Model.Subscription;
import Model.Team;

public class alreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	private Object obj;
	
	public alreadyExistException(Object coach) {
		setObject(coach); 
	}
	
	@Override
	public String getMessage() {
		if(obj instanceof Coach){
		return "Error! Coach with ID:\n"
				+ ((Coach) getObject()).getId()	
		        + "already exists!";
		}
		if(obj instanceof Player){
			return "Error! Player with ID:\n"
					+ ((Player) getObject()).getId()	
			        + "already exists!";
			}
		if(obj instanceof Team){
			return "Error! Team with ID:\n"
					+ ((Team) getObject()).getId()	
			        + "already exists!";
			}
		if(obj instanceof Stadium){
			return "Error! Stadium with ID:\n"
					+ ((Stadium) getObject()).getId()	
			        + "already exists!";
			}
		if(obj instanceof Receptionist){
			return "Error! Receptionist with ID:\n"
					+ ((Receptionist) getObject()).getId()	
			        + "already exists!";
			}
		if(obj instanceof Customer){
			return "Error! Customer with ID:\n"
					+ ((Customer) getObject()).getId()	
			        + "already exists!";
			}
		if(obj instanceof Subscription){
			return "Error! Subscription with ID:\n"
					+ ((Subscription) getObject()).getId()	
			        + "already exists!";
			}
		return null;
	}

	public Object getObject() {
		return obj;
	}
	
	public void setObject(Object coach) {
		this.obj = coach;
	}
	
}
