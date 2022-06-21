package rapidApi_practice;


import security_certificate.ServerTrustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class SportsAPI {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://weatherapi-com.p.rapidapi.com/future.json?q=London&dt=2022-12-25");
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        ServerTrustManager serverTrustManager = new ServerTrustManager();
        sslContext.init(null, new TrustManager[] { serverTrustManager }, new java.security.SecureRandom());

        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setSSLSocketFactory(sslContext.getSocketFactory());
        con.setRequestProperty("X-RapidAPI-Key", "1d0551b94amsh38f9b4ca482d1e3p1add46jsn9fa5ca9e3b41");
        con.setRequestProperty("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");

        String inputLine;
        StringBuffer response  = new StringBuffer();
        BufferedReader in      = null;
        String cEncode	       = con.getHeaderField("Content-Encoding");
        int responseCode       = con.getResponseCode();
        String responseMessage = (String)con.getResponseMessage();

        if("200".equals(responseCode)){
            if (cEncode != null && ( cEncode.toLowerCase().indexOf("gzip") > -1
                    || cEncode.toLowerCase().indexOf("deflate") > -1
                    || cEncode.toLowerCase().indexOf("compress") > -1)) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(con.getInputStream())));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            con.disconnect();

            System.out.println("RESULT_MSG : "+  response.toString());
        }else{
            System.err.println("responseMessage : "+ responseMessage);
            System.err.println("responseCode : "+ responseCode);
        }
    }
}
