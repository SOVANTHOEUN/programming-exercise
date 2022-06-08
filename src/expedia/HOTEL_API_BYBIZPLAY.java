package expedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.parser.ParseException;

import jex.json.JSONObject;

//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;

//import security_certificate.ServerTrustManager;

public class HOTEL_API_BYBIZPLAY{

	public HOTEL_API_BYBIZPLAY() {  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		expediaGateRun();
//		System.out.println("now:: "+DateTimeUtil.currentDateTimeString());
	}

	public static String getAuthHeaderValue(String apiKey, String secret) {
		Date date = new java.util.Date();
		Long timestamp = (date.getTime() / 1000);
		String signature = null;
		try {
			String toBeHashed = apiKey + secret + timestamp;
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(toBeHashed.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			signature = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String authHeaderValue = "EAN APIKey=" + apiKey + ",Signature=" + signature + ",timestamp=" + timestamp;
		return authHeaderValue;
	}

	private static void expediaGateRun() {
		// 변수 생성
		String apiLan = "language=ko-KR";
		String apiUrl = "https://test.ean.com/2.3/properties/content?"+apiLan;
		
		String strApiTrnOutput = "";
		try {
			int cntProperty = 0;
			System.out.println("BIZTRIP_DEV_2020 Eps is zero:: "+cntProperty);
//			JSONParser parser = new JSONParser();
			strApiTrnOutput = connect(apiUrl, "&include=property_ids");
			
			JSONObject mResult = new JSONObject();
			mResult = JSONObject.fromObject(strApiTrnOutput.toString());
			Iterator<String> respData = mResult.keySet().iterator();
			System.out.println("BIZTRIP_DEV_2020 Eps is length:: "+mResult.toString());
			
//			String apiContent = connect(apiUrl, "&property_id=21558356");
//			System.out.println("BIZTRIP_DEV_2020 Eps is :: "+21558356+" == "+apiContent);
			while(respData.hasNext()) {
//				System.out.println("KEY:: "+getPropertyKeyJson(apiContent).keySet().toString());
//				System.out.println("VALUE:: "+getPropertyKeyJson(apiContent).values().toString());
//				System.out.println("BIZTRIP_DEV_2020 Eps is :: "+cntProperty+" property_id: "+respData.next());
//				String apiContent = connect(apiUrl, "&property_id="+respData.next()+"&include=address");
				String apiContent = connect(apiUrl, "&property_id="+respData.next());
				System.out.println("BIZTRIP_DEV_2020 Eps is :: "+cntProperty+" == "+apiContent);
				cntProperty++;
			}
			
			System.out.println("total cntProperty:: "+cntProperty);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String connect(String url, String paramReq) throws Exception {
		String USER_AGENT 		= "Mozilla/5.0";
		String strJsonResult	= "";
		String fullURL = url + paramReq;

		try {
			URL connectUrl = new URL(fullURL);
			
			SSLContext sslContext = SSLContext.getInstance("SSL");
			ServerTrustManager serverTrustManager = new ServerTrustManager();
			sslContext.init(null, new TrustManager[] { serverTrustManager }, new java.security.SecureRandom());
			
			HttpsURLConnection con = (HttpsURLConnection) connectUrl.openConnection();
			con.setSSLSocketFactory(sslContext.getSocketFactory());
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept", "application/json");
		    con.setRequestProperty("Cache-Control", "no-cache");
		    con.setRequestProperty("Connection", "keep-alive");
		    con.setRequestProperty("cache-control", "no-cache");
			con.setRequestProperty("Authorization",
					getAuthHeaderValue("tm513e4b1bj9i6n2c01eoh0t8", "dnl6q8khebn7n"));
			
			BufferedReader inStream	= new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder response	= new StringBuilder();
			String inputLine;
			
			while ((inputLine = inStream.readLine()) != null) {
				response.append(inputLine);
			}
			strJsonResult = response.toString();
			
			inStream.close();
			con.disconnect();
		} catch (SocketTimeoutException e) {
			System.out.println("API Response ERROR:: SocketTimeoutException");
			e.printStackTrace();
		}catch(MalformedURLException e){
			System.out.println("API Response ERROR:: MalformedURLException");
			e.printStackTrace();
		}catch(NoSuchAlgorithmException e){
			System.out.println("API Response ERROR:: NoSuchAlgorithmException");
			e.printStackTrace();
		}catch(KeyManagementException e){
			System.out.println("API Response ERROR:: KeyManagementException");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("API Response ERROR:: IOException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("API Response ERROR:: Exception");
			e.printStackTrace();
		} finally {

		}

		return strJsonResult;
	}
	
	public static JSONObject getPropertyKeyJson(String propJson){
		JSONObject mResult = new JSONObject();
		mResult = JSONObject.fromObject(propJson.toString());
		
		return mResult;
	}

}


class ServerTrustManager implements X509TrustManager{

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		// TODO Auto-generated method stub
		arg0[0].checkValidity();
		arg0[0].getIssuerUniqueID();
		arg0[0].getSubjectDN();
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
