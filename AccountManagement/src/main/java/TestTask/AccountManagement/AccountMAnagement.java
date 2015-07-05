package TestTask.AccountManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMAnagement {
	public String findAccountByName(String name){
		DBconnect db=new DBconnect();
		db.init();
	    
	    ResultSet rs;
	    String account= null;
		try {
			rs = db.queryResult("SELECT * FROM TEST WHERE NAME = '"+name+"'");
			if (rs.next()) account=rs.getString("NAME")+" | "+rs.getString("SURNAME");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
        db.dispose();
        return account;
	}
	
	public boolean editSurname(String name, String newSurname){
		DBconnect db=new DBconnect();
		db.init();
	    
	    boolean result=false;    
		try {
			int res = db.update("UPDATE TEST SET SURNAME='"+newSurname+"' WHERE NAME = '"+name+"'");
			if (res>0) result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
        db.dispose();
        return result;
	}
	
}
