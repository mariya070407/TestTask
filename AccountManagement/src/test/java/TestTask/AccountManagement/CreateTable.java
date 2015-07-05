package TestTask.AccountManagement;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CreateTable {
	 
	  public static void createAndFillTable() throws Exception {
		DBconnect db=new DBconnect();
		db.init();
	    
		db.execute("DROP TABLE IF EXISTS TEST");
	    db.execute("CREATE TABLE TEST(NAME VARCHAR(60) PRIMARY KEY, SURNAME VARCHAR(60))");
	    db.execute("INSERT INTO TEST VALUES('Ivan', 'Ivanov')");
	    db.execute("INSERT INTO TEST VALUES('Petr', 'Petrov')");
	    db.execute("INSERT INTO TEST VALUES('Vasilii', 'Vasilev')");
	    db.execute("INSERT INTO TEST VALUES('Sidor', 'Sidorov')");
	 
       db.dispose();
	  }
	   
	  public static void viewTable(){
			DBconnect db=new DBconnect();
			db.init();
			ResultSet rs;
			try {
				rs = db.queryResult("SELECT * FROM TEST");
				System.out.println("\n");
			    while (rs.next()) {
			    	String name = rs.getString("NAME");
			    	System.out.println(rs.getString("SURNAME")+" "+name);
			    }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{db.dispose();}
	  }
	  
}
