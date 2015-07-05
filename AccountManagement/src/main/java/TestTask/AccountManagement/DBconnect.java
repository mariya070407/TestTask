package TestTask.AccountManagement;

import java.sql.*;

public class DBconnect {
	  private Connection con = null;
	  private String username = "sa";
	  private String password = "";
	  private String URL = "jdbc:h2:~/test";
	  private Statement st;

	  public void init(){
		    try {
				Class.forName("org.h2.Driver");			
			    con = DriverManager.getConnection(URL, username, password);		    
			    st = con.createStatement();
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public void dispose() {
		  try {
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	
	  public ResultSet queryResult(String query) throws SQLException{
		  return st.executeQuery(query);
	  }
	  
	  public boolean execute(String query) throws SQLException{
		return st.execute(query);		  
	  }

	  public int update(String query) throws SQLException{
		  return st.executeUpdate(query);
	  }

}
