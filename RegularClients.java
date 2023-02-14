package datastructures;
/**
 * 
 * @author ibagr
 * RegularClients is a child class of Clients and it represents a regular client
 */
public class RegularClients extends Clients {
	
    /**
    * constructor to initialize the properties of the regular client
    * @param name : name of the regular client
    * @param email : email of the regular client
    * @param userID : unique identification number of the regular client
    */
	public RegularClients(String name, String email, int userID) {
		super(name, email, userID);
	}
}
