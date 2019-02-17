package backend;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

public class JSONUtility {
	
	
	public static Tenant getTenantById(String s) {
		
		System.out.println("inne i jsonkonverter");
		JSONObject obj_JSON = new JSONObject(s);
	
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

	public static List<Tenant> getAllTenants(String s) {
		
		ArrayList<Tenant> list = new ArrayList<>();
		Tenant tempTenant;
		JSONArray results = new JSONArray(s);
		
		
		for (int i = 0; i < results.length(); i++) 
    	{
			JSONObject tenant = results.getJSONObject(i);
			String _until;
			int tenantID = tenant.getInt("id");
			int apartmentNumber = tenant.getInt("apartmentNumber");
			String firstName = tenant.getString("firstName");
			String lastName = tenant.getString("lastName");
			String ss_number = tenant.getString("ss_number");
			String mobile = tenant.getString("mobile");
			String email = tenant.getString("email");
			String _from = tenant.getString("_from");
			try {_until = tenant.getString("_until");} 
			catch (JSONException e) {_until = "Nuvarande Hyresgäst";}
			String address = tenant.getString("address");
			String postal_code = tenant.getString("postal_code");
			String city = tenant.getString("city");
			String notes = tenant.getString("notes");
			
			tempTenant = new Tenant(tenantID, apartmentNumber, firstName, lastName, ss_number, mobile, email, _from,_until, notes, address, postal_code, city);
			
			list.add(tempTenant);
			
			
    	}	
		return list;
		
	}
	
	
	

	

}
