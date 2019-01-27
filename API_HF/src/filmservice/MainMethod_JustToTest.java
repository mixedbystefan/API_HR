package filmservice;

import java.util.ArrayList;
import java.util.List;

public class MainMethod_JustToTest {

	public static void main(String[] args) throws Exception {
		DBUtil dBUtil = new DBUtil();
		List<Apartment> list = new ArrayList<Apartment>();
		
		
		list = dBUtil.getAllApartments();
		for (Apartment apartment : list) {System.out.println(apartment);};
		
		// denna main-metod testar bara uppkopplingen mot databasen och vad som returneras
		// http://localhost:8080/Hyresforeningen/rest/ApartmentService/apartments
	}

}
