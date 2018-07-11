import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class oneServlet extends HttpServlet {  
 
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
     
      response.setContentType("text/html");
    
      PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
                String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
	
      
      Statement stmt = null;
      try {
          
Class.forName("oracle.jdbc.driver.OracleDriver"); 
Connection con = DriverManager.getConnection("jdbc:mysql://mysql6.000webhost.com/a5671545_red","a5671545_shyam","Spartacus86");

PreparedStatement ps = con.prepareStatement("insert into user_master values(?,?,?,?,?)");
		ps.setString(1,fname);
		ps.setString(2,lname);
		ps.setString(3,email);
                ps.setString(4,uname);
		ps.setString(5,upass);
		
		int i = ps.executeUpdate();
		if(i>0){
		out.println("Successfull registered");
		out.close();
		}
		else{
		out.println("Failed");
		}
    } catch(Exception e){
e.printStackTrace();
        }
	
   }
}