package apartmentservice;


	import java.sql.*;
import java.util.ArrayList;
import java.util.List;



	public class DBUtil 
	{
		
		public DBUtil() {con = Connect.GetConnection();}
		Connection con;
		
		public void deleteTenant(String theTenantID) throws SQLException 
		{
			Connection conn=null;
			PreparedStatement statement = null;
			
			try {
				
				int tenantID = Integer.parseInt(theTenantID);
				conn = Connect.GetConnection();
				String sql = "delete from tenant where id =?";
				
				statement= conn.prepareStatement(sql);
				statement.setInt(1, tenantID);
				statement.execute();
				
				}
			
			finally {conn.close(); statement.close();}
			
			
		}
		 
		 public void addTenant(Tenant tempTenant) throws SQLException 

			{
				
				Connection conn = null;	
				PreparedStatement pstmt= null;
				String query ="";
			
				try {
					conn = Connect.GetConnection();
					
					query = "insert into Tenant (apartmentNumber, firstName, lastName, "
							+ "ss_number,mobile, email) "
							+ "values(?,?,?,?,?,?)";
					
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, tempTenant.getApartmentNumber());
					pstmt.setString(2, tempTenant.getFirstName());
					pstmt.setString(3, tempTenant.getLastName());
					pstmt.setString(4, tempTenant.getSs_number());
					pstmt.setString(5, tempTenant.getMobile());
					pstmt.setString(6, tempTenant.getEmail());
					pstmt.execute();
					
				} 
				
				catch (SQLException e) 
				{	
					e.printStackTrace();
				}
				
				finally {conn.close(); pstmt.close(); conn.close();}	
			
			}
		
		
		
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
		
		public List<Tenant> getAllInfo() throws Exception 
		{
			System.out.println("Testing");
			List<Tenant> allInfo = new ArrayList<>();
			System.out.println("Testing2");
			//Connection con;
			System.out.println("Testing3");
			Statement stmt = null;
			System.out.println("Testing4");
			ResultSet rs = null;
			System.out.println("Testing5");
			Tenant tenant = null;
			
			
			try 
			{
			
				
				
				
				String query ="select h.elevator, h.gym, h.sauna, h.storage_room, h.construction_date,h.address,"
						+ "h.postal_code, h.city, a.id, a.house_number, a.size, a.rooms, a.balcony, a.floor, a.bofond,"
						+ "a.rent, a.fridge, a.freezer, a.stove, a.notes, t.id, t.apartmentNumber, t.firstName, t.lastName, "
						+ "t.ss_number, t.mobile, t.email, t._from, t._until,t.notes from apartment as a left join tenant as t on "
						+ "t.apartmentNumber = a.id left join house as h on h.id=a.house_number";

				con = Connect.GetConnection();
				stmt = con.createStatement();
				
				rs = stmt.executeQuery(query);

				
				while (rs.next()) 
				{
					boolean elevator = rs.getBoolean("h.elevator");
					boolean gym = rs.getBoolean("h.gym");
					boolean sauna = rs.getBoolean("h.sauna");
					boolean storage_room = rs.getBoolean("h.storage_room");
					String construction_date = rs.getString("h.construction_date");
					String address= rs.getString("h.address");
					String postal_code= rs.getString("h.postal_code");
					String city= rs.getString("h.city");
					int id = rs.getInt("a.id");
					int house_number = rs.getInt("a.house_number");
					double size = rs.getDouble("a.size");
					int rooms= rs.getInt("a.rooms");
					boolean balcony = rs.getBoolean("a.balcony");
					int floor= rs.getInt("a.floor");
					double bofond = rs.getDouble("a.bofond");
					double rent = rs.getDouble("a.rent");
					String fridge= rs.getString("a.fridge");
					String freezer= rs.getString("a.freezer");
					String stove= rs.getString("a.stove");
					String a_notes= rs.getString("a.notes");
					int id2 = rs.getInt("t.id");
					int apartmentNumber = rs.getInt("t.apartmentNumber");
					String firstName = rs.getString("t.firstName");
					String lastName = rs.getString("t.lastName");
					String ss_number = rs.getString("t.ss_number");
					String mobile = rs.getString("t.mobile");
					String email = rs.getString("t.email");
					String _from = rs.getString("t._from");
					String _until = rs.getString("t._until");
					String notes = rs.getString("t.notes");
					
					
				
				tenant = new Tenant(elevator, gym, sauna, storage_room, construction_date,address,postal_code, city, id, 
						house_number,size, rooms, balcony,floor, bofond, rent, fridge, freezer, stove, a_notes, id2, apartmentNumber,
						firstName, lastName,ss_number, mobile, email,_from, _until, notes );
				
				allInfo.add(tenant);
					
					
				}
				
				
				
				return allInfo;
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
		
		public int updateTenant(Tenant tempTenant) throws Exception
		{
			
			
			
				Connection conn=null;
				PreparedStatement statement = null;
				
				String sql = "update tenant " 
						+ "set apartmentNumber = ?, firstName= ?, lastName = ?, "
						+ "ss_number = ?, mobile = ?, email = ?, _from = ?, _until = ?, notes = ? "
						+ "where id= ?"; 
				try {
					conn = Connect.GetConnection();
				
				
				
			
				statement= conn.prepareStatement(sql);
				
				statement.setInt(1, tempTenant.getApartmentNumber());
				statement.setString(2, tempTenant.getFirstName());
				statement.setString(3, tempTenant.getLastName());
				statement.setString(4, tempTenant.getSs_number());
				statement.setString(5, tempTenant.getMobile());
				statement.setString(6, tempTenant.getEmail());
				statement.setString(7, tempTenant.get_from());
				statement.setString(8, tempTenant.get_until());
				statement.setString(9, tempTenant.getNotes());
				statement.setInt(10, tempTenant.id);
				
				statement.execute();
				
				}
			
			finally {conn.close(); statement.close();}
				return 1;
				
		}

		// Tar bort en hyresgäst från databasen


		  
	}
