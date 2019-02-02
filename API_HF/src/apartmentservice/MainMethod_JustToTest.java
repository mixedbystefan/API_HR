package apartmentservice;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
public class MainMethod_JustToTest {
	private Client client;
	private static String REST_SERVICE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/tenant";
	
	
	public MainMethod_JustToTest() { 
		client = ClientBuilder.newClient();	}
	
	
	public static void main(String[] args) {
		MainMethod_JustToTest justToTest = new MainMethod_JustToTest();
		justToTest.addTenant("1", "Adda", "Jansson", "790430-8721", "070-2345678", "Adda@me.com"); 
		
	}
	private void addTenant(String apartmentnumber, String firstName, String lastName, String ss_number, String mobile, String email){
	      Form form = new Form();
	      form.param("apartmentnumber", apartmentnumber);
	      form.param("firstName", firstName);
	      form.param("lastName", lastName);
	      form.param("ss_number", ss_number);
	      form.param("mobile", mobile);
	      form.param("email", email);
	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      System.out.println(callResult);	}
	
	
	
}



