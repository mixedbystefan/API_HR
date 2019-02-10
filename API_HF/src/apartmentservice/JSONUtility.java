package apartmentservice;

import org.json.JSONObject;

public class JSONUtility {
	
	
	public static Tenant getTenantById(String s) {
		
		System.out.println("inne i jsonkonverter");
		JSONObject obj_JSON = new JSONObject(s);
		
		//int id = obj_JSON.getInt("id");
		int apartmentNumber = obj_JSON.getInt("apartmentNumber");
		String firstName = obj_JSON.getString("firstName");
		String lastName = obj_JSON.getString("lastName");
		String ss_number = obj_JSON.getString("ss_number");
		String mobile = obj_JSON.getString("mobile");
		String email = obj_JSON.getString("email");
		String _from = obj_JSON.getString("_from");
		String _until = obj_JSON.getString("_until");
		String notes = obj_JSON.getString("notes");
		
		Tenant tempTenant = new Tenant(apartmentNumber, firstName, lastName, ss_number,mobile, email, _from,_until, notes);
		
		
		return tempTenant;
	
}

	

}
