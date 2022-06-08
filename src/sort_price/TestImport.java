package sort_price;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestImport {
	static Date today = new Date();
	static SimpleDateFormat formatYYMMDD		= new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat formatYYMMDDHHMMSS	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static String CREATE_DATE	= formatYYMMDDHHMMSS.format(today);
	static String TODAY_DATE	= formatYYMMDD.format(today);
	static String NEW_DATE		= "";
	public static void main(String [] args) {
		long start = System.currentTimeMillis();
		try {
			File file = new File("C:\\Users\\SOVANTHOEUN\\Desktop\\json.txt");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String strJson = null;
			while((strJson = bf.readLine()) != null) {
				JSONObject outputObj1 = new JSONObject(strJson);
		    	JSONArray  calendarsArray = new JSONArray(outputObj1.get("data").toString());
				for(int i = 0;i < calendarsArray.length();i++){
		    		JSONObject outputObj2 = new JSONObject(calendarsArray.get(i).toString());
		    		String  property = outputObj2.get("placeNo").toString();
		    		
		    		JSONArray  outRoomTypeArr2 = new JSONArray(outputObj2.get("roomTypes").toString());
		    		Map<String,String> map1 = new HashMap();
		    		Map<String,String> map2 = new HashMap();
		    		for(int j = 0; j < outRoomTypeArr2.length(); j++){
		    			JSONObject outCalendarObj  = new JSONObject(outRoomTypeArr2.get(j).toString());
		    			JSONArray  outCalendarArr  = new JSONArray(outCalendarObj.get("calendars").toString());
		    			
			    		for(int k = 0;k < outCalendarArr.length();k++){
			    			JSONObject outCalendarDtlObj  = new JSONObject(outCalendarArr.get(k).toString());
			    			String chDt	 = outCalendarDtlObj.get("checkInDate").toString();
			    			String pri	 = (map1.get(chDt) == null ? "" : map1.get(chDt)+",") + outCalendarDtlObj.get("price").toString();
			    			String dipri = (map2.get(chDt) == null ? "" : map2.get(chDt)+",") + outCalendarDtlObj.get("discountPrice").toString();
			    			map1.put(chDt, pri);
			    			map2.put(chDt, dipri);
			    		}
			    	}
		    		
//		    		System.out.println(property + " :NEW_DATE: " + NEW_DATE + " :: map1 :: " + map1);
//		    		System.out.println(property + " :NEW_DATE: " + NEW_DATE + " :: map2 :: " + map2);
		    		
		    		for(int j = 0; j < 60; j++) {
	    				Calendar c = Calendar.getInstance();
			    		c.setTime(formatYYMMDD.parse(TODAY_DATE));
			    		c.add(Calendar.DAY_OF_MONTH, j);
			        	NEW_DATE = formatYYMMDD.format(c.getTime());
//			        	String[] price		= map1.get(NEW_DATE).split(",");
//			        	String[] disPrice	= map2.get(NEW_DATE).split(",");
			        	
			        	String [] price	=  {"0"};
			        	if(map1.get(NEW_DATE) != null) {
			        		price	= map1.get(NEW_DATE).split(",");
			        	}
			        	
			        	String [] disPrice	= {"0"};
			        	if(map2.get(NEW_DATE) != null) {
			        		disPrice	= map2.get(NEW_DATE).split(",");
			        	}

			        	int min1 = 0;
			        	int min2 = 0;
			        	ArrayList<Integer> al1 = new ArrayList();
			        	ArrayList<Integer> al2 = new ArrayList();
			        	
			        	for(int k = 0;k < price.length;k++) {
			        		al1.add(price[k].equals("0")	? 0 : Integer.parseInt(price[k]));
			        		al2.add(disPrice[k].equals("0") ? 0 : Integer.parseInt(disPrice[k]));
			        		
//			        		if(!price[k].equals("0")) {
//			        			al1.add(Integer.parseInt(price[k]));
//			        		}
//			        		if(!disPrice[k].equals("0")) {
//			        			al2.add(Integer.parseInt(disPrice[k]));
//			        		}
			        	}
			        	min1 = (int) Collections.min(al1);
			        	min2 = (int) Collections.min(al2);
			        	System.out.println(property + " :: " + NEW_DATE + " :: " + map1.get(NEW_DATE) + " :: min price : "+ min1 + " :: " + map2.get(NEW_DATE) + " :: min dis price : "+ min2);
	    			}
		    	}
			}
		}catch(Exception e) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 " + ( end - start )/1000.0 +"");
	}
	
}

/*
 							
  */


