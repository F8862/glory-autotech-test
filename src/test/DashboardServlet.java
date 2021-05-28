package test;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
@SuppressWarnings("serial")
public class DashboardServlet extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>"); 
         out.println("<a href=LogoutServlet>Logout</a><br>");
         try 
         {  
             Class.forName("oracle.jdbc.driver.OracleDriver");  
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
             PreparedStatement ps= con.prepareStatement("select * from QualityRecord");  
             ResultSet rs = ps.executeQuery(); 
             out.print("===Quality table===");
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>QualityaId</th><th>Name</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("qualityId");  
                 String nm = rs.getString("name");  
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  

         try 
         {  
             Class.forName("oracle.jdbc.driver.OracleDriver");  
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
             PreparedStatement ps= con.prepareStatement("select * from Stock");  
             ResultSet rs = ps.executeQuery(); 
             out.print("===Stock table===");
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>StockId</th><th>QualityId</th><tr>");  
             while (rs.next()) 
             {  
                 int n = rs.getInt("stockId");  
                 String nm = rs.getString("qualityId");  
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  

         try 
         {  
             Class.forName("oracle.jdbc.driver.OracleDriver");  
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
             PreparedStatement ps= con.prepareStatement("select * from Batch");  
             ResultSet rs = ps.executeQuery(); 
             out.print("===Batch table===");
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Id</th><th>BatchId</th><th>Mtr</th><th>StockId</th><tr>");  
             while (rs.next()) 
             {  
                 int n = rs.getInt("id");  
                 int m = rs.getInt("batchId");
                 int p = rs.getInt("mtr");
                 int q = rs.getInt("stockId");
                 out.println("<tr><td>" + n + "</td><td>" + m + "</td><td>" + p+ "</td><td>" + q+ "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  

     }  
 }  
