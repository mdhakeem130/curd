import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAOImp {
	public String insert( String name,String age,String mobile) 
	{
		Connection con =null;
		PreparedStatement pstm;
		String insertflage;
		try
		{
			MysqlConnection obj=new MysqlConnection();
			con=obj.getConnecion();
			pstm=con.prepareStatement("insert into student(name,age,mobile)values (?,?,?);");
			pstm.setString(1, name);
			pstm.setString(2, age);
			pstm.setString(3, mobile);
			int n=pstm.executeUpdate();
			
			System.out.println("nomber of records affected: " +n);
			if(n>=1)
			{
				insertflage="Success";
				System.out.println("record inserted successfully");
			}
			else
			{
				insertflage="false";
				System.out.println("record failed in insertion");
			}

		}
		catch(SQLException e)
		{
			insertflage="false";

			e.printStackTrace();
		}
		catch(Exception e)
		{
			insertflage="false";

			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				insertflage="false";

				e.printStackTrace();
			}
			catch(Exception e)
			{
				insertflage="false";

				e.printStackTrace();
			}
		}
		return insertflage;
		
	}
public ArrayList getAllDetails()
{
	Connection con=null;
	PreparedStatement pstm;
	String insertflage;
	ArrayList all_details=new ArrayList();
	
	try
	{
		MysqlConnection obj=new MysqlConnection();
		con=obj.getConnecion();
		pstm=con.prepareStatement("select id,name,age,mobile from student");
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next())
		{
			StudentBeam StudentBeam=new StudentBeam();
			StudentBeam.setId(""+rs.getInt(1));
			StudentBeam.setName(rs.getString(2));
			StudentBeam.setAge(rs.getString(3));
			StudentBeam.setMobile(rs.getString(4));
			
			all_details.add(StudentBeam);
		}
		
	}
	catch(SQLException e)
	{
		insertflage="false";

		
		e.printStackTrace();
	}
	catch(Exception e)
	{
		insertflage="false";

		e.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			insertflage="false";

			e.printStackTrace();
		}
		catch(Exception e)
		{
			insertflage="false";

			e.printStackTrace();
		}
	}
	return all_details;

}
public String deleteById(String id) 
{
	Connection con =null;
	PreparedStatement pstm;
	String updateflage;
	ArrayList all_details=new ArrayList();
	
	try
	
	{
	 int idd = Integer.parseInt(id);
		MysqlConnection obj=new MysqlConnection();
		con=obj.getConnecion();
		
		pstm=con.prepareStatement("delete from student where id=?");
		pstm.setInt(1, idd);
		
		int n=pstm.executeUpdate();
		if(n>=1)
		{
			updateflage="Success";
		}
		else
		{
			updateflage="Fail";
			
		}
			
		
}
	catch(SQLException e)
	{
		updateflage="false";

		e.printStackTrace();
	}
	catch(Exception e)
	{
		updateflage="false";

		e.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			updateflage="false";

			e.printStackTrace();
		}
		catch(Exception e)
		{
			updateflage="false";

			e.printStackTrace();
		}
	}
	return updateflage;
}
public StudentBeam viewStudent(String id)

{
	Connection con =null;
	PreparedStatement pstm;
	//String insertflage;
	StudentBeam StudentBeam=new StudentBeam();
	try
	{
		MysqlConnection obj=new MysqlConnection();
		con=obj.getConnecion();
		pstm=con.prepareStatement("select id,name,age,mobile from student where id=?");
		
		int idd=Integer.parseInt(id);
		pstm.setInt(1, idd);
		ResultSet  rs=pstm.executeQuery();
		
		while(rs.next())
		{
			
			StudentBeam.setId(""+rs.getInt(1));
			StudentBeam.setName(rs.getString(2));
			StudentBeam.setAge(rs.getString(3));
			StudentBeam.setMobile(rs.getString(4));
			
			
		}
		
	
	}
	catch(SQLException e)
	{
		//insertflage="false";

		e.printStackTrace();
	}
	catch(Exception e)
	{
		//insertflage="false";

		e.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			//insertflage="false";

			e.printStackTrace();
		}
		catch(Exception e)
		{
			//insertflage="false";

			e.printStackTrace();
		}
	}
	return StudentBeam;

}

public String updateStudent(StudentBeam obje)
{
	Connection con =null;
	PreparedStatement pstm;
	String message="";
	//StudentBeam StudentBeam=new StudentBeam();
	try
	{
		MysqlConnection obj=new MysqlConnection();
		con=obj.getConnecion();
		
		int iddd=Integer.parseInt(obje.getId());
		pstm=con.prepareStatement("update student set name=?,age=?,mobile=? where id=?");
		pstm.setString(1, obje.getName());
		pstm.setString(2, obje.getAge());
		pstm.setString(3, obje.getMobile());
		pstm.setInt(4, iddd);
		
		int n=pstm.executeUpdate();
		if(n>=1)
		{
			message="Success";
			//System.out.println("record inserted successfully");
		}
		else
		{
			message="false";
			//System.out.println("record failed in insertion");
		}
		
		
		
		
		
		
	
	}
	catch(SQLException e)
	{
		message="false";

		e.printStackTrace();
	}
	catch(Exception e)
	{
		message="false";

		e.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			//insertflage="false";

			e.printStackTrace();
		}
		catch(Exception e)
		{
			//insertflage="false";

			e.printStackTrace();
		}
	}
	return message;
	
}
}





 