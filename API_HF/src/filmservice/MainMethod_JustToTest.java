package filmservice;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
public class MainMethod_JustToTest {
	private Client client;
	private static String REST_SERVICE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/tenant";
	public MainMethod_JustToTest() { 
		client = ClientBuilder.newClient();	}
	
	
	public static void main(String[] args) {
		MainMethod_JustToTest justToTest = new MainMethod_JustToTest();
		justToTest.addTenant("Aina"); 
		
	}
	private void addTenant(String firstName){
	      Form form = new Form();
	      form.param("firstName", firstName);
	      //form.param("title", title);
	      //form.param("description", description);
	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      System.out.println(callResult);	}}

