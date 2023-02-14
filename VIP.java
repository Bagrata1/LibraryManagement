package datastructures;
/**
 * 
 * @author ibagr
 * VIP is a child class of Clients and it represents a VIP client
 */
public class VIP extends Clients {
    /**
    * constructor to initialize the properties of the VIP client
    * @param username : name of the VIP client
    * @param email : email of the VIP client
    * @param userID : ID number of the VIP client
    */
	public VIP(String username, String email, int userID) {
		super(username, email, userID);

	}

}
