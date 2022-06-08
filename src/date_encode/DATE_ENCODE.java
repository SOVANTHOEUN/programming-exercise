package date_encode;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DATE_ENCODE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		SimpleDateFormat formatYYMMDDHH	= new SimpleDateFormat(" 12:mm:ss");
		
		Instant now 		= Instant.now();
    	Instant yesterday	= now.minus(1, ChronoUnit.DAYS);
    	String YESTERDAY_DATE		= yesterday.toString().substring(0, 10);
    	
		String HOUR			= formatYYMMDDHH.format(today);
//		String hourEncoding = URLEncoder.encode(HOUR);
		String hourEncoding = URLEncoder.encode(" 11:00");
		String paramStr		= YESTERDAY_DATE + hourEncoding;
		System.out.println("paramStr:: "+paramStr);
		System.out.println("hourEncoding:: "+hourEncoding);
	}

}
