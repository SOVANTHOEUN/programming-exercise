package expedia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jex.json.JSONObject;
import security_certificate.ServerTrustManager;

public class HOTEL_API {
	private final String USER_AGENT = "Mozilla/5.0";

	public HOTEL_API() {}
	
	public String getAuthHeaderValue(String apiKey, String secret){
		Date date= new java.util.Date();
		Long timestamp = (date.getTime() / 1000);
		String signature = null;
		try {
		   String toBeHashed = apiKey + secret + timestamp;
		   MessageDigest md = MessageDigest.getInstance("SHA-512");
		   byte[] bytes = md.digest(toBeHashed.getBytes("UTF-8"));
		   StringBuilder sb = new StringBuilder();
		   for(int i=0; i< bytes.length ;i++){
		       sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		   }
		   signature = sb.toString();
		} catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
		}
		String authHeaderValue = "EAN APIKey=" + apiKey +  ",Signature=" + signature + ",timestamp=" + timestamp;
		return authHeaderValue;
	}
	
	
	// HTTP GET request
	
	private void sendGet(String targetUrl, String authHeaderValue){
		PrintWriter postReq    = null;

		try {
			URL connectUrl = new URL(targetUrl);
			SSLContext sslContext = SSLContext.getInstance("SSL");
			ServerTrustManager serverTrustManager = new ServerTrustManager();
			sslContext.init(null, new TrustManager[] { serverTrustManager }, new java.security.SecureRandom());
			HttpsURLConnection con = (HttpsURLConnection) connectUrl.openConnection();
			
			con.setSSLSocketFactory(sslContext.getSocketFactory());
			con.setRequestMethod("GET"); // optional default is GET
			con.setRequestProperty("User-Agent", USER_AGENT); // add request header
			con.setRequestProperty("Accept", "application/json");
		    con.setRequestProperty("Authorization", authHeaderValue);
		    con.setRequestProperty("Cache-Control", "no-cache");
		    con.setRequestProperty("Connection", "keep-alive");
		    con.setRequestProperty("cache-control", "no-cache");
			con.setDoOutput(true);
			
			JSONObject mApiTrnHead    = new JSONObject();
			mApiTrnHead.put("language","ko-KR");
			mApiTrnHead.put("include","property_ids");
			
			// JSONArray 전송
	        postReq = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
	        postReq.write(mApiTrnHead.toJSONString());
	        postReq.flush();
			
	        
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
//			int responseCode  = con.getResponseCode();
			in.close();
//			con.disconnect();
			// print result
//			System.out.println("HTTP 응답 코드 : " + responseCode);
			System.out.println("HTTP body : " + response.toString());
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String apiKey = "tm513e4b1bj9i6n2c01eoh0t8";
		String secret = "dnl6q8khebn7n";
		
		HOTEL_API http = new HOTEL_API();

		System.out.println("GET으로 데이터 가져오기");
		try {
			http.sendGet("https://test.ean.com/2.3/properties/content", http.getAuthHeaderValue(apiKey,secret));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
