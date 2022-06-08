package download_image;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang.builder.ToStringStyle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadImage {
	private static Date today = new Date();
	private static SimpleDateFormat FORMAT_YYYY	= new SimpleDateFormat("yyyy");
	private static SimpleDateFormat FORMAT_MM	= new SimpleDateFormat("MM");
	private static SimpleDateFormat FORMAT_DD	= new SimpleDateFormat("dd");
	
	public static class ServerTrustManager implements X509TrustManager{
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException { }
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			arg0[0].checkValidity();
			arg0[0].getIssuerUniqueID();
			arg0[0].getSubjectDN();
		}
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		String imageRec = "[ { \"category\": \"REPRESENTATION\", \"categoryName\": \"대표 사진\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba325201c9.57772106.jpg\" }, { \"category\": \"INTERIOR\", \"categoryName\": \"숙소 내부\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abeea2d8a29.34625202.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee96f58d0.53704370.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee94bb912.67548498.JPG\" }, { \"category\": \"INTERIOR\", \"categoryName\": \"숙소 내부\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abeea0c0e89.21806845.JPG\" }, { \"category\": \"INTERIOR\", \"categoryName\": \"숙소 내부\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee9b9fdb3.70183788.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee926bb47.03355759.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee8e43392.87377144.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee8ac2765.30834074.JPG\" }, { \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\", \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/07/595abee88501c7.48175120.JPG\" } ]";
		String roomRec  = "[{\"no\":111290,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3b97c412.12347491.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3b6dd765.30031624.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3b4442c3.07353899.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3b24ea12.74124505.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3b03f508.49807718.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3acccf90.39024930.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3a95d186.65413610.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3a6eaee9.17811208.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3a3bd290.98668299.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3a1548b1.16249656.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"일반실 A (핸드안마기,PC,42TV)\",\"language\":\"ko\"}],\"maxCapacity\":2,\"description\":null,\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2},{\"no\":111291,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba38627431.07613803.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba37c1cc39.50315998.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba37959dc9.85554384.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba371e23c8.61998521.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba36c737a1.81717629.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba36a67f17.45363311.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3667c120.40853319.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3641af43.07250175.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba361dcc96.97615136.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba35e63af8.33123570.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba35c12f32.87043130.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba35a01f12.90701811.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"준특실 (핸드안마기,욕조,PC,55TV)\",\"language\":\"ko\"}],\"maxCapacity\":2,\"description\":null,\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2},{\"no\":111292,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3414e950.78402537.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba33dca399.76158971.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba33b114c0.04666759.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba33896c85.78916757.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba335fed12.16607474.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3334f9a3.07250299.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba33038ba0.78206715.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba32c31650.35774735.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"무비룸 (핸드안마기,욕조,PC,65TV,2.1우퍼)\",\"language\":\"ko\"}],\"maxCapacity\":2,\"description\":null,\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2},{\"no\":111896,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba325201c9.57772106.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3293eb83.94822417.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba326788a5.87043040.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba322a72a6.35417596.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba31e58ae5.14662333.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba31b69f33.63616659.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba31819a58.43349934.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba31506869.21834528.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3124a9b5.46817364.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba30f23e71.78832625.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba30c84138.20439579.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba30a42637.93978318.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba307bde40.57877428.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba30575332.68003495.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"씨네마룸 (핸드안마기,2인욕조,PC,75TV,5.1우퍼)\",\"language\":\"ko\"}],\"maxCapacity\":2,\"description\":null,\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2},{\"no\":111897,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba399652a5.16521057.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba39708225.70015332.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3916fc99.95472377.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba388a9071.70593501.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba381b0000.28180417.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba37e942e3.38718892.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba376d7ce7.54760617.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba37443b48.23782595.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba36ed8c38.24946903.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba368c6374.60259160.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"일반실 B (핸드안마기,욕조,PC,42TV)\",\"language\":\"ko\"}],\"maxCapacity\":3,\"description\":\"\",\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2},{\"no\":112075,\"globalSalesAgree\":0,\"images\":[{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba357c68c1.16848026.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba35500990.03138872.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba352b8f88.14662749.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3502f7d8.18214585.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba34c972b0.24645901.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba34a6e4a0.39089897.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba347c5445.47928516.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba345ac6b7.10862405.jpg\"},{\"category\":\"ROOM_TYPE\",\"categoryName\":\"객실 사진\",\"url\":\"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba3434d429.53074466.jpg\"}],\"isOpen\":1,\"rentAgree\":0,\"name\":[{\"name\":\"VIP 무비룸 (핸드안마기,2인욕조,PC,65TV,2.1우퍼)\",\"language\":\"ko\"}],\"maxCapacity\":2,\"description\":null,\"breakfast\":0,\"confirmedReservation\":1,\"capacity\":2}]";
		String test		= "http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/04/06/595aba325201c9.57772106.jpg";
		String splitSlash[]	= test.split("/");
		String strSlash		= splitSlash[splitSlash.length-1];
		String splitDot[]	= test.split("\\.");
		String imgExten		= splitDot[splitDot.length-1];
		System.out.println(imgExten);
		System.out.println((new SimpleDateFormat("yyyyMMddHHmmss")).format(today));
		
		try {
			JSONArray imageRecArr = new JSONArray(imageRec.toString());
			for(int i = 0; i < imageRecArr.length(); i++) {
				JSONObject imageRecItem = new JSONObject(imageRecArr.get(i).toString());
//				System.out.println("BIZTRIP_2020 YnjApiCall saveImage: "+imageRecArr.get(i));
				System.out.println("BIZTRIP_2020 YnjApiCall saveImage: "+imageRecItem.get("url"));
				/*if(!imageRecItem.isNull("url")) {
					System.out.println("BIZTRIP_2020 YnjApiCall saveImage: "+imageRecItem.get("url").toString());
				}else {
					System.out.println("BIZTRIP_2020 YnjApiCall saveImage 22 ");
				}*/
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String authKey = "eyJhbGciOiJIUzI1NiJ9.eyJuaWQiOiJzYW5kYm94IiwiaXNzIjoieWFub2xqYV95YW4iLCJpYXQiOjE1NDY5MDU2MDAsImV4cCI6MTg2MjUyNDgwMH0.6ZhBaucVNY45WiFQqdop2-nt_L5kjtUSXtF5cp95EO0";
		URL url = new URL("https://yadev.yanolja.com/v5/2020/07/10/18/5f0833187d6dc9.43707301.png");
		SSLContext sslContext = SSLContext.getInstance("SSL");
		ServerTrustManager serverTrustManager = new ServerTrustManager();
		sslContext.init(null, new TrustManager[] { serverTrustManager }, new java.security.SecureRandom());
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		
		// set security param to API
		con.setSSLSocketFactory(sslContext.getSocketFactory());
		con.setRequestMethod("GET");
	    con.setRequestProperty("Authorization", "Bearer "+authKey);
	    
	    // get response for output
	    InputStream in = new BufferedInputStream(con.getInputStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf2 = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf2))){
			out.write(buf2, 0, n);
		}
		out.close();
		in.close();
		
		// create new folder
		boolean isCreate = true, isMMCreate = true, isDDCreate = true;
		UUID uuid	   = UUID.randomUUID();
		String imgName = uuid.toString() +".png";
		String directory_FileYYName = "C:\\Users\\SOVANTHOEUN\\Desktop\\"+FORMAT_YYYY.format(today) +"\\"+ imgName;
		String directory_FileMMName = "C:\\Users\\SOVANTHOEUN\\Desktop\\"+FORMAT_YYYY.format(today) +"\\"+ FORMAT_MM.format(today) +"\\"+ imgName;
		String directory_FileDDName = "C:\\Users\\SOVANTHOEUN\\Desktop\\"+FORMAT_YYYY.format(today) +"\\"+ FORMAT_MM.format(today) +"\\"+ FORMAT_DD.format(today) +"\\"+ imgName;
		
		File fileYear	= new File(directory_FileYYName);
		File fileMM		= new File(directory_FileMMName);
		File fileDD		= new File(directory_FileDDName);
		
		fileYear.getParentFile().mkdir();
		fileMM.getParentFile().mkdir();
		fileDD.getParentFile().mkdir();
		
		// save image into directory
		byte[] response = out.toByteArray();
//		if(isCreate) {
			FileOutputStream fos = new FileOutputStream(directory_FileDDName);
			fos.write(response);
			fos.close();
//		}
		
		System.out.println("BIZTRIP_2020 YnjApiCall isCreate: "+directory_FileDDName);
		System.out.println("BIZTRIP_2020 YnjApiCall response2: "+response);
		System.out.println("BIZTRIP_2020 YnjApiCall responseMessage: "+response.toString());
	}
}
