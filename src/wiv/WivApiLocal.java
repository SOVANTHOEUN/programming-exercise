package wiv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import jex.json.JSONArray;
import jex.json.JSONObject;
import jex.json.JSONUtil;

public class WivApiLocal {
	String MAIN_URL = "http://asp-channeling.goodchoice.kr/v1";
	String AUTH_KEY = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJPcGVuQXBpIiwiWC1BUFBMSUNBVElPTi1TRUxMRVItQ0hBTk5FTC1JRCI6NDQsIkVOVklST05NRU5ULUNPREUiOiJwcm9kIiwiWC1BUFBMSUNBVElPTi1TRUxMRVItQ0hBTk5FTC1DT0RFIjoiYml6cGxheSIsIlgtQVBQTElDQVRJT04tU1VQUExJRVItQ09ERSI6IllFT0dJIiwiWC1BUFBMSUNBVElPTi1VU0VSLUlEIjoyMywiZXhwIjoxNzQwMjg1NDY3fQ.x2z3-J-Y4hgVRB1DPTSco_NeHLAejTkx3VwYsFjG42HdReXCvZhWR-dyI0JiqsfmmkbO21i4dy5XKxfbufbxuA";
	public static void main(String[] args) {
		WivApiLocal wivObj	= new WivApiLocal();
		JSONArray arrHotel	= new JSONArray();
		try {
			for(int i = 0; i <= 5;i++) {
				String propId = ""+ (i + 8 * 2);
				Map<String, String> resultContents = wivObj.sendYnjApi("/properties/" + propId, "GET", "");
				arrHotel.add(resultContents.get("RESULT_MSG"));
			}
			wivObj.saveHotelToFiles(arrHotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Map<String, String> sendYnjApi(String targetUrl, String method, String parameters) throws Exception {
		Map<String, String> result = new HashMap();
		String lastUrl = targetUrl;
		
		URL url = new URL(MAIN_URL + lastUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod(method);
		con.setRequestProperty("Accept-Encoding",	"UTF-8");
		con.setRequestProperty("Accept-Charset",	"UTF-8");
		con.setRequestProperty("Accept",			"application/json");
		con.setRequestProperty("Content-Type",		"application/json; charset=UTF-8");
	    con.setRequestProperty("Authorization",		"Bearer "+AUTH_KEY);
	    
	    if(method.equals("POST")) {
	    	System.out.println("BIZTRIP_2020 WivApiCall parameters: "+method +" :: "+parameters);
	    	con.setRequestProperty("Accept-Encoding",	"gzip");
	    	con.setRequestProperty("Content-Type",		"application/json");
	    	con.setDoOutput(true);
	    	OutputStream os = con.getOutputStream();
	    	os.write(parameters.getBytes("UTF-8"));
	    	os.flush();
	    	os.close();
	    }
	    
		int responseCode = con.getResponseCode();
		String responseMessage = (String)con.getResponseMessage();
		System.out.println("BIZTRIP_2020 WivApiCall URL11111: "+responseMessage);
		
		StringBuffer response = new StringBuffer();
		BufferedReader in = null;
		String inputLine;
		
		try{
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		}catch(Exception e){
			in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
		}
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		con.disconnect();
		
		System.out.println("BIZTRIP_2020 WivApiCall responseCode 지금	: "+method +" :: "+responseCode);
		System.out.println("BIZTRIP_2020 WivApiCall responseMessage	: "+method +" :: "+response.toString());
		
		result.put("RESULT_CODE", responseCode+"");
		result.put("RESULT_MSG",  response.toString());
		return result;
	}
	
	public void saveHotelToFiles(JSONArray hotelData) {
		File file			= new File("C:\\Users\\SOVANTHOEUN\\Desktop\\여기어때's hotel\\WIV_hotels_data.txt");
		FileWriter fr		= null;
		BufferedWriter br	= null;
		String dataWithNewLine = hotelData + System.getProperty("line.separator");
		
		try{
		    fr = new FileWriter(file);
		    br = new BufferedWriter(fr);
		    br.write(dataWithNewLine);
		    System.out.println("BIZTRIP_2020 WivApiCall Save Success.");
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("BIZTRIP_2020 WivApiCall Error Success.");
		}finally{
		    try {
		        br.close();
		        fr.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}

}
