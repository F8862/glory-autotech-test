package test;
import java.io.IOException; 
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        Cookie ck[]=request.getCookies();
        ck[0].setValue("");
        ck[0].setMaxAge(0);              
        out.print("you are successfully logged out!");  
        request.getRequestDispatcher("login.html").include(request, response);  
    }  
}  
