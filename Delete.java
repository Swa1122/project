
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

  public class Delete {

	public static void main(String args[]){
	
    Connection con  = null;
	Statement stmt = null;
	ResultSet  rs  = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		con  = DriverManager.getConnection(url,"system","root");
		stmt  = con.createStatement();
		
		String sql="delete from student where student_no = 102 "  ;//
		rs  = stmt.executeQuery(sql);
			System.out.println("________________________________________");
		while(rs.next()){
		int id = rs.getInt("student_no");		
		String name = rs.getString("student_name");		
		String dob =rs.getString("dob");
		String doj =rs.getString("doj");
			
		System.out.printf("%-5d %-10s %-10s %-10s\n",id,name,dob,doj);
			
		System.out.println("________________________________________");
					
			
		}
		
		
		
		
		
		
	   
    }catch(ClassNotFoundException e){
		System.out.println("DriverERROR ::Driver class not loaded "+e.getMessage() );
	}catch(SQLException e){
		System.out.println("DB ERROR  "+e.getMessage() );
	}catch(Exception e){
		System.out.println( " Other ERROR   "+e.getMessage() );
	}finally{
	    if(con!=null ){
		  try{
		  con.close();
		    System.out.println("con close successfuly");
		
		}catch(SQLException e){
		    System.out.println("DB Close ERROR " + e.getMessage());
		  }
		}
	}//finally end
	
	
	
	
	  
	}//end main

}//end class
