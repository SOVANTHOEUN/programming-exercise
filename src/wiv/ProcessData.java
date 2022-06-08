package wiv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import jex.sys.JexSystemConfig;

public class ProcessData {

	public static void main(String[] args) {
		Connection conn = null;
	    Statement st 	= null;
	    ResultSet rs 	= null;
		
		String url 		= "jdbc:postgresql://172.28.200.114:54311/biztripdevdb";
	    String user 	= "biztripdev";
	    String password = "biztripdev123";
		
	    System.out.println("==== imgSeq ====");
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String imgSeq = "0";
			String sql = "SELECT NEXTVAL('SEQ_BT_HOTEL_IMAGE') IMAGE_SEQ";
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) imgSeq = rs.getString("IMAGE_SEQ");
			System.out.println("imgSeq: "+imgSeq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
