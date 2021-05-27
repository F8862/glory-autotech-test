package test;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
public class LoginDAO {
	public boolean z;
	  public boolean login(HttpServletRequest request,ServletContext sct){
		  try{
			  Connection con=DBConnection.getcon();
			  
				  PreparedStatement ps=con.prepareStatement
						  ("select * from UserLogin where userName=? and password=?");
				  ps.setString(1,request.getParameter("userName"));
				  ps.setString(2,request.getParameter("password"));
				  ResultSet rs=ps.executeQuery();
				  if(rs.next()){
					  z=true;
					  sct.setAttribute("Name", rs.getString(3));
				    }
		  }catch(Exception e){e.printStackTrace();}
		        return z;  
	  }
}
		


