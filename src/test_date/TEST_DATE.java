package test_date;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.json.JSONException;
import org.json.JSONObject;

import com.wecambodia.thirdparty.weplatform.cmo.SystemCodeListOutCMO;

public class TEST_DATE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Date today = new Date();
//		SimpleDateFormat formatYYMMDD = new SimpleDateFormat("YYYY-MM-DD");
//		SimpleDateFormat formatYYMMDDHH = new SimpleDateFormat("HHmmss");
//		String TODAY_DATE	= formatYYMMDD.format(today);
//		
//		String YESTERDAY_DATE	= "";
//		Instant now 		= Instant.now();
//		Instant yesterday	= now.minus(1, ChronoUnit.DAYS);
//		YESTERDAY_DATE		= yesterday.toString().substring(0, 10);
//		
//		System.out.println("YESTERDAY_DATE:: "+YESTERDAY_DATE);
//		System.out.println("now:: "+now);
//		
//		Calendar calendar = Calendar.getInstance();
//		try{
//			calendar.setTime(formatYYMMDD.parse(TODAY_DATE));
//		}catch(ParseException e){
//			e.printStackTrace();
//		}
//		
//		calendar.add(Calendar.DATE, -1);
//		String NEW_DATE = formatYYMMDD.format(calendar.getTime());
//		
//		System.out.println("New Date: "+NEW_DATE);
//		System.out.println("Calendar: "+calendar.toString());
		
//		SimpleDateFormat formatYYMMDD = new SimpleDateFormat("YYYY-MM-DD");
//		Date date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L);
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DATE, -1);
//		String lastDate = formatYYMMDD.format(calendar);
//		
//		System.out.println("calendar:: "+lastDate);
		
//		LocalDate today = LocalDate.now();
//		LocalDate yesterday = today.minus(Period.days(1));
//		System.out.println("yesterday: "+yesterday.toDate());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar     = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		String YESTERDAY_DATE = dateFormat.format(calendar.getTime());
		System.out.println("01 : " + YESTERDAY_DATE);
		
	}

}
