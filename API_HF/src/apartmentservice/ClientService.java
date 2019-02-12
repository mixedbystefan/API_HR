package apartmentservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.json.JSONArray;
public class ClientService {
	private Client client;
	private static String ADD_URL = "http://localhost:8080/API_HF/rest/ApartmentService/add";
	private static String DELETE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/delete";
	private static String UPDATE_URL = "http://localhost:8080/API_HF/rest/ApartmentService/update";
	private static String GET_TENANT_URL = "http://localhost:8080/API_HF/rest/ApartmentService/tenant/";
	private static String GET_TENANTS_URL = "http://localhost:8080/API_HF/rest/ApartmentService/tenants";
	
	
	
	public ClientService() { 
		client = ClientBuilder.newClient();	}
	
	
	public static void main(String[] args) {
		ClientService clientService = new ClientService();
		
	}
	
	public List<Tenant> getAllTenants() {
		System.out.println("Detta är från clientservice");
		ClientService clientService = new ClientService();
		GenericType<String> string = new GenericType<String>() {};
		String s = clientService.client
		         .target(GET_TENANTS_URL)
		         .request(MediaType.APPLICATION_JSON)
		         .get(string); // hämta JSON-representation
		System.out.println("Detta är från clientservice" + s);
		ArrayList<Tenant> list = (ArrayList<Tenant>) JSONUtility.getAllTenants(s);
		return list;
		
		
		
	}
	
	
	
	public Tenant getTenant(String tenantid) {
		System.out.println("Detta är från clientservice");
		ClientService clientService = new ClientService();
		GenericType<String> string = new GenericType<String>() {};
		String s = clientService.client
		         .target(GET_TENANT_URL + tenantid)
		         .request(MediaType.APPLICATION_JSON)
		         .get(string); // hämta JSON-representation
		System.out.println("Detta är från clientservice" + s);
		return JSONUtility.getTenantById(s);
		
		
		
	}
	void addTenant(String apartmentnumber, String firstName, String lastName, String ss_number, String mobile, String email, String _from,String _until, String notes){
	      Form form = new Form();
	      
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
	         .target(ADD_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      System.out.println(callResult);	}
	
	// Tar bort ett Objekt-Klienten skickar med id som styr vilket objekt som ska raderas
	public String deleteTenant(String tenantid) {
		String callResult = client
		         .target(DELETE_URL)
		         .path("/{tenantid}")
		         .resolveTemplate("tenantid", tenantid)
		         .request(MediaType.APPLICATION_JSON)
		         .delete(String.class);
		 return callResult;
	}
	
	// Uppdaterar en hyresgäst, samma uppbyggnad som POST men här körs http-metoden PUT.
	
	void updateTenant(String id, String apartmentnumber, String firstName, String lastName, String ss_number, String mobile, String email, String _from, String _until, String notes){
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





