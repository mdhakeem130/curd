
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
	public class MysqlConnection 
	{
		/*public static void main(String[] args) {
			MysqlConnection co=new MysqlConnection();
			Connection con=co.getConnecion();
		}*/	
		
		Connection con=null;
		/* ResourceBundle resource=  ResourceBundle.getBundle("com.resource.DBConnection");
		 String username=resource.getString("db_user_name");
		 String password=resource.getString("db_pass");
		  
		 System.out.println("DB user name: "+username);
		 
		 System.out.println("DB user password name : "+password);
		 */	public Connection getConnecion()
		{
	
		 
		
	  try {
		Class.forName("com.mysql.jdbc.Driver" );
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/curd_db", "root", "1254" );
		if(con!=null)
		{
			System.out.println("connection estabilshed successfully");
		}
		else
		{
			System.out.println("Connection could not connect");
		}
	  }
	  catch (ClassNotFoundException e) 
	  {

		e.printStackTrace();
	}
	  catch(SQLException e)
	  {
		e.printStackTrace();  
	  }
	return con;
		
		}
		
	}






