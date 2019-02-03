package apartmentservice;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
public class MainMethod_JustToTest {
	private Client client;
	private static String ADD_URL = "http://localhost:8080/API_HF/rest/ApartmentService/tenant";
	private static String DELETE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/delete";
	private static String UPDATE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/update";
	
	
	public MainMethod_JustToTest() { 
		client = ClientBuilder.newClient();	}
	
	
	public static void main(String[] args) {
		MainMethod_JustToTest justToTest = new MainMethod_JustToTest();
		//justToTest.addTenant("1", "Adda", "Jansson", "790430-8721", "070-2345678", "Adda@me.com"); 
		justToTest.deleteTenant("1");
		
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
	         .target(ADD_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      System.out.println(callResult);	}
	
	private void deleteTenant(String tenantid) {
		String callResult = client
		         .target(DELETE_URL)
		         .path("/{tenantid}")
		         .resolveTemplate("tenantid", tenantid)
		         .request(MediaType.APPLICATION_JSON)
		         .delete(String.class);
		 System.out.println(callResult);
	}
	
	private void updateTenant(){
	      Form form = new Form();
	      form.param("id", "1");
	      form.param("name", "suresh");
	      form.param("profession", "clerk");

	      String callResult = client
	         .target(UPDATE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .put(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      /*String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }*/

	      System.out.println("Test case name: testUpdateUser, Result: ");
	   }

	
	
}





