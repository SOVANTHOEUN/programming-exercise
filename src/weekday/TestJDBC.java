package weekday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) {
		Connection conn = null;
	    Statement state	= null;
	    String url		= "jdbc:postgresql://10.254.241.141:54396/biztripdevdb?rewriteBatchedStatements=true";
	    String user		= "biztripdev";
	    String password	= "biztripdev123";
		
		try{
			// create connection to DB
			conn	= DriverManager.getConnection(url, user, password);
	    	conn.setAutoCommit(false);
			
	    	String query = "select * from bt_hotel_list limit 1";
	    	
	    	// create statement
	    	state = conn.createStatement();
	    	
	    	// get result
	    	ResultSet result = state.executeQuery(query);
	    	ResultSetMetaData rsmd = result.getMetaData();
	    	System.out.println("======= RESULT SET =======");
	    	while(result.next()) {
	    		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
		    		System.out.print(rsmd.getColumnName(i) + "\t\t");
		    		System.out.println(result.getString(rsmd.getColumnName(i)));
		    	}
	    	}
	    	
	    	// execute query
			conn.commit();
			state.close();
			conn.close();			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
