package filmservice;

import java.sql.*;

public class Connect 
{
	static final String connString = "jdbc:mysql://localhost:3306/";
	static final String database ="Hyresforeningen";
	static final String timezoneFix = "?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
	static final String password = "tlabTLAB4321";
	static int count=0;
			
	public static Connection GetConnection() 
	{
	
		try{
				count++;
				String url = connString + database + timezoneFix;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection(
				url,"root",password);
				if (count==1) 
					{
						System.out.println("uppkopplad");
					}
				return con;
			} 
		
		catch (Exception e) { System.err.println("Uppkopplingen misslyckades");
		
			}
				return null;
			}	
}