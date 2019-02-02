package apartmentservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
@Path("/ApartmentService")
public class ApartmentService 
{
	
	
	private DBUtil dBUtility = new DBUtil();
   @GET
   @Path("/apartments")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Tenant> getApartments() throws Exception 
   {
	   
	 //List<Apartment> out = dBUtility.getAllApartmentsSimple();
	 
	 //List<Apartment> out = dBUtility.getAllApartments();
	   
	 List<Tenant> out = dBUtility.getAllInfo();
	   return out;
 
	   
	   //http://localhost:8080/API_HF/rest/ApartmentService/apartments
   }
   
   @GET
   @Path("/apartments/{apartment_id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Tenant getApartment(@PathParam("apartment_id") String apartment_id) throws Exception
   {
	   System.out.println("apartmentID körs");
      ApartmentService as = new ApartmentService();
      Integer a_Id = Integer.parseInt(apartment_id);
      List<Tenant> ApartmentList = as.getApartments();
      for (Tenant tenant : ApartmentList) 
      {
    	  if (tenant.getApartmentNumber()==a_Id) {return tenant;} // avsluta metoden med return
      }
      return null; // om ingen film med rätt id hittas
   }
   //
   
   @GET
   @Path("/apartmentquery")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Tenant> getApartmentFromQuery(
		@QueryParam("city") String city,
		@QueryParam("maxrent") Double rent, 
		@QueryParam("minrooms") Double rooms,
		@QueryParam("minsize") Double size
		   ) throws Exception {
	   System.out.println("apartmentquery körs");
	   ApartmentService as = new ApartmentService();
	   List<Tenant> ApartmentList = as.getApartments();
	   List<Tenant> Result = new ArrayList<Tenant>();
	   for (Tenant tenant : ApartmentList) 
	   {
		   System.out.println("inne i loopen!");
		   System.out.println("size!" + size);
		   System.out.println("rent!" + rent);
		   System.out.println("rooms!" + rooms);
		   System.out.println("rcity!" + city);
		   
		   // 
		   if (city!=null) 
		   {
			   System.out.println("1");
			   System.out.println(tenant.getCity());
			   
			   // Om det anges en stad eller "Alla" så går appen in i If-satsen
			   
			   if (tenant.getCity().equalsIgnoreCase(city) || city.equalsIgnoreCase("alla")) 
			   {
				   
				   // Om Size är angett så går appen in här
				   if (size!=null) 
				   {	// Om maxrent är angett går appen in i Ifsatsen, annars returneras svar enligt storlek
					   if (rent!=null) 
					   {
						   if ( tenant.getSize()>=size) 
						   {
							   if (rooms!=null) 
							   {
								   
								   if (tenant.getRent()<=rent) 
								   {
									   if(tenant.getRooms()>=rooms) 
									   {
										   Result.add(tenant);
									   }
								   }
							   
							   }
							   
							   else if (tenant.getRent()<=rent) 
							   {
								   Result.add(tenant);
							   }
							   
						   }
						   
					   }
					   
					   else if ( tenant.getSize()>=size) {Result.add(tenant);}
					    	     
				   } 
				   
				   else Result.add(tenant);
			   
			   }
			   
			   
		    	     
		   }
		   
		   
		   /*if (size!=null) 
		   {
			   if ( tenant.getSize()>=size) {Result.add(tenant);}
		    	     
		   }
	    	  
		   if (rent!=null) 
		   {
			   if (tenant.getRent()<=rent) {Result.add(tenant);}
		    	     
		   }*/
		   
		   
		   
		   if (rooms!=null) 
		   {
			   if (tenant.getRooms()>= rooms) {Result.add(tenant);}
		    	     
		   }
		   
	    		  
	    		  
	    	  
	    	  
	    	  
	    	  
	    	 
	   }
	   return Result; // om ingen film med rätt id, titel eller beskrivning hittas
	}
   
   @POST
   @Path("/tenant")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createTenant(@FormParam("apartmentnumber") String apartmentNumber,
		   @FormParam("firstName") String firstName,
		   @FormParam("lastName") String lastName,
		   @FormParam("ss_number") String ss_number,
		   @FormParam("mobile") String mobile,
		   @FormParam("email") String email,
   @Context HttpServletResponse servletResponse) throws SQLException{
	  
	System.out.println("create körs");
	int apnr = Integer.parseInt(apartmentNumber);
    Tenant tempTenant = new Tenant(apnr, firstName, lastName, ss_number, mobile, email);
    System.out.println(tempTenant);
    
    dBUtility.addTenant(tempTenant);
  	
      
      try {
	    
    	} catch (Exception e) {
System.out.println("Lyckades inte skriva till databas.");
return "<result>failure</result>";
}
      return "<result>success</result>";
   }

  //http://localhost:8080/API_HF/rest/ApartmentService/apartments/apartmentnumber=1 
  

@DELETE
   @Path("/deleteID/{tenantId}")
   @Produces(MediaType.APPLICATION_JSON)
   public String deleteFile(@PathParam("tenantId") String TenantID) throws SQLException {
	System.out.println("delete körs");
      dBUtility.deleteTenant(TenantID);
      //System.out.println(filename);
      if(1==1){
          return "{'result':'success'}";
      } else return "{'result':'failure'}";
   }

   //http://localhost:8080/API_HF/rest/ApartmentService/apartmentquery?size=40
   //http://localhost:8080/API_HF/rest/ApartmentService/create?apartmentnumber=1

// || tenant.getCity().equals(city) || tenant.getRooms()==(rooms) || tenant.getRent()<=(rent)
   
   // Problemet nu är att den tar alla hyresgäster , dvs lägenheter med utflyttad och boende tas flera gånger

}

