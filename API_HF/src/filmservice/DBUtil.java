package filmservice;


	import java.sql.*;
import java.util.ArrayList;
import java.util.List;



	public class DBUtil 
	{
		
		public DBUtil() {con = Connect.GetConnection();}
		Connection con;
		
		
		
		public List<Apartment> getAllApartments() throws Exception 
		{
			System.out.println("Testing");
			List<Apartment> Apartments = new ArrayList<>();
			System.out.println("Testing2");
			//Connection con;
			System.out.println("Testing3");
			Statement stmt = null;
			System.out.println("Testing4");
			ResultSet rs = null;
			System.out.println("Testing5");
			
			
			try 
			{
			
				
				
				
				String query = "select * from Apartment";

				con = Connect.GetConnection();
				stmt = con.createStatement();
				
				rs = stmt.executeQuery(query);

				
				while (rs.next()) 
				{
					
					int id = rs.getInt("id");
					int house_number = rs.getInt("house_number");
					double size = rs.getDouble("size");
					int rooms= rs.getInt("rooms");
					boolean balcony = rs.getBoolean("balcony");
					int floor= rs.getInt("floor");
					double bofond = rs.getDouble("bofond");
					double rent = rs.getDouble("rent");
					String fridge= rs.getString("fridge");
					String freezer= rs.getString("freezer");
					String stove= rs.getString("stove");
					String notes = rs.getString("notes");
					
			
					
					Apartment tempApartment = new Apartment(id, house_number, size,rooms, balcony,floor,bofond,rent,fridge,freezer, stove, notes);
					Apartments.add(tempApartment);
					
					
				}
				
				
				
				return Apartments;
			}

			finally {rs.close();stmt.close();con.close();}
			
			
		}  

		
			
		public List<Apartment> getAllApartmentsSimple() throws Exception 
		{
			List<Apartment> out = new ArrayList<Apartment>();
			System.out.println("hahahaha");
			out.add(new Apartment(10, 13, 122,4, true,2,1233,4000,"false","false", "false", "Hejsvejs"));
			  
			   return out;
		}
		  
	}
