package test;
import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet { 
	public ServletContext sct;
	@Override
	public void init() throws ServletException{
		sct=this.getServletContext();
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        if(new LoginDAO().login(request,sct)){
        	String Name=(String) sct.getAttribute("Name");
        	Cookie ck=new Cookie("name",Name);  
            response.addCookie(ck); 
            sct.removeAttribute("Name");
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+Name);  
            request.getRequestDispatcher("dashboard.html").forward(request, response);  
        }else{  
            out.print("sorry, please check your userName or password!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  

