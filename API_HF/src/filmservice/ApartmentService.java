package filmservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/ApartmentService")
public class ApartmentService {
	
	
	private DBUtil dBUtility = new DBUtil();
   @GET
   @Path("/apartments")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Apartment> getApartments() throws Exception {
	   
	 //List<Apartment> out = dBUtility.getAllApartmentsSimple();
	 
	 List<Apartment> out = dBUtility.getAllApartments();
	   return out;
 
   }
}

