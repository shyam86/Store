import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class twoServlet extends HttpServlet {  
 
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
     
      response.setContentType("text/html");
    
      PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
	
      
     
     try{
Class.forName("oracle.jdbc.driver.OracleDriver"); 
Connection con = DriverManager.getConnection("jdbc:mysql://mysql6.000webhost.com/a5671545_red","a5671545_shyam","Spartacus86");

Statement st=null;
PreparedStatement ps=null;
ResultSet rs=null;
ps=con.prepareStatement("Select * from user_master where uname = ? and upass = ?");
ps.setString(1,uname);
ps.setString(2,upass);
rs=ps.executeQuery();
if(rs.next())
{
String redirectURL = "hello.html";
response.sendRedirect(redirectURL);
}
else 
{
out.println("Username doesnot exists");
}
}catch(Exception e){
e.printStackTrace();
}
	
   }
}