package apartmentservice;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
public class MainMethod_JustToTest {
	private Client client;
	private static String ADD_URL = "http://localhost:8080/API_HF/rest/ApartmentService/add";
	private static String DELETE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/delete";
	private static String UPDATE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/update";
	
	
	public MainMethod_JustToTest() { 
		client = ClientBuilder.newClient();	}
	
	
	public static void main(String[] args) {
		MainMethod_JustToTest justToTest = new MainMethod_JustToTest();
		// Metoder som simulerar en input från en användare
		justToTest.addTenant("1", "Addadad", "Jansson", "790430-8721", "070-2345678", "Adda@me.com"); 
		justToTest.deleteTenant("1");
		justToTest.updateTenant("2", "2", "Mikael", "Yttling", "710529-6160", "888-888 88 88", "MikkeY@hotmail.com", "2007-01-01", "2008-06-07", "telefonnummer uppdaterat!" );
		
		// Lägger till en hyresgäst, ett form Objekt skapas som använder metoden param för att skicka värdena med hjälp av clientobjektet.
		// URL'en och typ av media skickas också med.
	}
	public void addTenant(String apartmentnumber, String firstName, String lastName, String ss_number, String mobile, String email){
	      Form form = new Form();
	      form.param("apartmentnumber", apartmentnumber);
	      form.param("firstName", firstName);
	      form.param("lastName", lastName);
	      form.param("ss_number", ss_number);
	      form.param("mobile", mobile);
	      form.param("email", email);
	      String callResult = client
	         .target(ADD_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      System.out.println(callResult);	}
	
	// Tar bort ett Objekt-Klienten skickar med id som styr vilket objekt som ska raderas
	private void deleteTenant(String tenantid) {
		String callResult = client
		         .target(DELETE_URL)
		         .path("/{tenantid}")
		         .resolveTemplate("tenantid", tenantid)
		         .request(MediaType.APPLICATION_JSON)
		         .delete(String.class);
		 System.out.println(callResult);
	}
	
	// Uppdaterar en hyresgäst, samma uppbyggnad som POST men här körs http-metoden PUT.
	
	private void updateTenant(String id, String apartmentnumber, String firstName, String lastName, String ss_number, String mobile, String email, String _from, String _until, String notes){
	      Form form = new Form();
	      form.param("id", id);
	      form.param("apartmentnumber", apartmentnumber);
	      form.param("firstName", firstName);
	      form.param("lastName", lastName);
	      form.param("ss_number", ss_number);
	      form.param("mobile", mobile);
	      form.param("email", email);
	      form.param("_from", _from);
	      form.param("_until", _until);
	      form.param("notes", notes);
	      String callResult = client
	         .target(UPDATE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .put(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      

	      
	   }

	
	
}





