package backend;

// Lagrar lösenord för att slippa hårdkoda detta i programmet.

public class Config {
	final static String passWord = "tlabTLAB4321";

	public static String getPassword() {
		return passWord;
	}

	

}
