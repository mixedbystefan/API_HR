package backend;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import sun.nio.cs.HistoricallyNamedCharset;

@Path("/ApartmentService")
public class ApartmentService 
{
	
	
	private DBUtil dBUtility = new DBUtil();
	private static final String SUCCESS_RESULT="<result>success</result>";
	private static final String FAILURE_RESULT="<result>failure</result>";
	
   @GET
   @Path("/apartments")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Tenant> getApartments() throws Exception 
   {
	 // Hämtar alla lägenheter från databasen    
	 List<Tenant> out = dBUtility.getAllInfo();
	 return out;
 
   }
   
   @GET
   @Path("/tenants")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Tenant> getTenants() throws Exception 
   {
	 // Hämtar alla hyresgäster från databasen  
	 List<Tenant> out = dBUtility.getAllInfo();
	 return out;
 
   }
   
   // Metoden tar in en ID på en lägenhet, omvandlar det till en int, hämtar alla lägenheter till en lista
   // Går igenom listan och när lägenhetsnumret överenstämmer med ID'et som tas in i metoden så returneras detta objekt,
   
   @GET
   @Path("/apartments/{apartment_id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Tenant getApartment(@PathParam("apartment_id") String apartment_id) throws Exception
   {
	 
      ApartmentService as = new ApartmentService();
      Integer a_Id = Integer.parseInt(apartment_id);
      List<Tenant> ApartmentList = as.getApartments();
      for (Tenant tenant : ApartmentList) 
      {
    	  if (tenant.getApartmentNumber()==a_Id) {return tenant;} 
      }
      return null; 
   }
   
   // Hämtar hyresgäst utifrån ID
   
   @GET
   @Path("/tenant/{tenant_id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Tenant getTenant(@PathParam("tenant_id") String tenant_id) throws Exception
   {
	 
      Tenant theTenant = dBUtility.getTenant(tenant_id);
      return theTenant; 
   }
   
   // Används inte i Appen "HyresgästAppen" då den inte bygger på lägenheter
   // Används däremot i uppgift 2 i labb3
   // Hämtar lägenhet(er) efter några specifika krav
   
   // Metoden tar in city=X, maxrent=X osv från URL'en och dessa sparas i nya variabler, alla lägenheter hämtas från databasen 
   // En ny lista med Resultat (en lista av typen hyresgästobjekt) skapas, Listan med alla lägenheter loopas igenom och ifsatserna sorterar
   // ut de svar som överestämmer med villkoren. Slutligen returnerar metoden en lista med de svar som översenstämmer med användarens önskemål
   
   @GET
   @Path("/apartmentquery")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Tenant> getApartmentFromQuery(
		@QueryParam("city") String city,
		@QueryParam("maxrent") Double rent, 
		@QueryParam("minrooms") Double rooms,
		@QueryParam("minsize") Double size
		   ) throws Exception {
	   ApartmentService as = new ApartmentService();
	   List<Tenant> ApartmentList = as.getApartments();
	   List<Tenant> Result = new ArrayList<Tenant>();
	   for (Tenant tenant : ApartmentList) 
	   {

			   if (city!=null)  
			   {

					   if (tenant.getCity().equalsIgnoreCase(city) || city.equalsIgnoreCase("alla")) 
					   {
						   
						  if (rent!=null) 
							  {
								  if(tenant.getRent()<=rent) 
									  
									  {
									  	if(rooms!=0) 
									  	{
									  		if (tenant.getRooms()>=rooms) 
									  		{
									  			if(size!=0) 
									  			{
									  				if(tenant.getSize()>=size) {Result.add(tenant);}
									  				
									  			}
									  			
									  			else Result.add(tenant);
									  		
									  		}
									  		
									  	}
									  	
									  	else  Result.add(tenant);
									  
									  }
					  
							  }
						  else Result.add(tenant);
															
					   }
     
			   }
	 
	   }
	   
	   return Result; 
	}
   
   // Får användarens input som hämtas upp med FormParam och lagras i nya variabler.
   // Ett objekt skapas och skickas till DBUtil för att läggas till i databasen.
   
   @POST
   @Path("/add")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createTenant(
		   @FormParam("apartmentnumber") String apartmentNumber,
		   @FormParam("firstName") String firstName,
		   @FormParam("lastName") String lastName,
		   @FormParam("ss_number") String ss_number,
		   @FormParam("mobile") String mobile,
		   @FormParam("email") String email,
		   @FormParam("_from") String _from,
		   @FormParam("_until") String _until,
		   @FormParam("notes") String notes,
   @Context HttpServletResponse servletResponse) throws SQLException{

      try 
      {
    	  int apnr = Integer.parseInt(apartmentNumber);
    	  Tenant tempTenant = new Tenant(apnr, firstName, lastName, ss_number, mobile, email,_from, _until, notes);
    	  dBUtility.addTenant(tempTenant);
      } 
      
      catch (Exception e) {
    		return "Det gick inte att spara ny hyresgäst";
}
      return "Ny hyresgäst sparad";
   }
   
   // Validerar användarnamn och lösenord
   
   @POST
   @Path("/validate")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String ValidateAdmin(
		   @FormParam("userName") String userName,
		   @FormParam("password") String password,
   @Context HttpServletResponse servletResponse) throws SQLException
   {
	
	   boolean result = dBUtility.validateAdmin(userName, password);
	   if (result) {return "true";}
	   else return "false";	  
   }
   
   @POST
   @Path("/validateAPI")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String ValidateAdmin(
		   @FormParam("password") String password,
   @Context HttpServletResponse servletResponse) throws SQLException
   {
	
	   boolean result = dBUtility.validateAdmin(password);
	   if (result) {return "true";}
	   else return "false";	  
   }

  
  // Tar in ett id från klienten och skickar det till DBUtil som tar bort detta objekt från databasen.

	@DELETE
	   @Path("/delete/{tenantid}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public String deleteFile(@PathParam("tenantid") String TenantID) throws SQLException 
	{
		
		
	      int result = dBUtility.deleteTenant(TenantID);
	      
	      if(result==1){
	          return "Hyresgäst med ID " + TenantID + " har raderats!";
	      } else return FAILURE_RESULT;
	   }
	
	// I princip Som POST men anropar annan metod för att uppdatera hyresgäst.

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") String id,
			@FormParam("apartmentnumber") String apartmentNumber,
			   @FormParam("firstName") String firstName,
			   @FormParam("lastName") String lastName,
			   @FormParam("ss_number") String ss_number,
			   @FormParam("mobile") String mobile,
			   @FormParam("email") String email,
			   @FormParam("_from") String _from,
			   @FormParam("_until") String _until,
			   @FormParam("notes") String notes,	  
	   @Context HttpServletResponse servletResponse) throws Exception{
		int apnr = Integer.parseInt(apartmentNumber);
		int _id = Integer.parseInt(id);
		
	   Tenant tempTenant = new Tenant(_id, apnr, firstName, lastName, ss_number, mobile, email,_from, _until, notes);
	   String result = dBUtility.updateTenant(tempTenant);
	   return result;
	}

   
}

