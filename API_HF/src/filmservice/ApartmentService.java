package filmservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
   public Tenant getApartmentFromQuery(
		@QueryParam("filmid") String filmid,
		@QueryParam("description") String description, 
		@QueryParam("title") String title) {
	   ApartmentService as = new ApartmentService();
	   List<Tenant> ApartmentList = as.getApartments();
	   for (Tenant tenant : ApartmentList) {
	    	  if (tenant.getId().equals(filmid) || film.getDescription().equals(description) || film.getTitle().equals(title)) {
	    		  return film; // avsluta metoden med return
	    	  }
	      }
	      return null; // om ingen film med rätt id, titel eller beskrivning hittas
	}



}

