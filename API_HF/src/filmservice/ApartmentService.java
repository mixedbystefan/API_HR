package filmservice;

import java.io.IOException;
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
		@QueryParam("rent") Double rent, 
		@QueryParam("rooms") Double rooms,
		@QueryParam("size") Double size
		   ) throws Exception {
	   ApartmentService as = new ApartmentService();
	   List<Tenant> ApartmentList = as.getApartments();
	   List<Tenant> Result = new ArrayList<Tenant>();
	   for (Tenant tenant : ApartmentList) 
	   {
	    	  if ( tenant.getSize()>=(size) ) 
	    	  {
	    		  
	    		  Result.add(tenant);
	    		  
	    	  }
	    	 
	   }
	   return Result; // om ingen film med rätt id, titel eller beskrivning hittas
	}
   
   @POST
   @Path("/apartments")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createTenant(@FormParam("apartmentnumber") int apartmentnumber,
      @FormParam("firstName") String firstName,
      @FormParam("lastName") String lastName,
      @FormParam("SSNumber") String SSNumber,
      @FormParam("mobile") String mobile,
      @FormParam("email") String email,
      @Context HttpServletResponse servletResponse){
	  
	  Tenant tempTenant = null;
      try {
    	  tempTenant = new Tenant(apartmentnumber, firstName,lastName, SSNumber, mobile, email);
  	} catch (Exception e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}
      
      try {
	    dBUtility.addTenant(tempTenant); 
    	} catch (Exception e) {
System.out.println("Lyckades inte skriva till databas.");
return "<result>failure</result>";
}
      return "<result>success</result>";
   }

   
  

/*@DELETE
   @Path("/deletefile/{filename}")
   @Produces(MediaType.APPLICATION_JSON)
   public String deleteFile(@PathParam("tenantId") String filename){
      File file = new File(filename + ".txt");
      System.out.println(filename);
      if(file.delete()){
          return "{'result':'success'}";
      } else return "{'result':'failure'}";
   }*/

   //http://localhost:8080/API_HF/rest/ApartmentService//apartmentquery?size=40

// || tenant.getCity().equals(city) || tenant.getRooms()==(rooms) || tenant.getRent()<=(rent)
   
   // Problemet nu är att den tar alla hyresgäster , dvs lägenheter med utflyttad och boende tas flera gånger

}

