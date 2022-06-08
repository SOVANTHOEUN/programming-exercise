package teststring;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TEST_DATA {
	public static void main(String[] args) {
//		String jsonTest = "[{\"phone\":{\"country_code\":\"82\",\"number\":\"01212121212\",\"area_code\":\"\"},\"special_request\":\"\",\"smoking\":false,\"title\":\"vongvong\",\"given_name\":\"vong\",\"family_name\":\"vong\",\"email\":\"vong@gmail.com\"},{\"phone\":{\"country_code\":\"82\",\"number\":\"02321121221\",\"area_code\":\"\"},\"special_request\":\"\",\"smoking\":false,\"title\":\"thoeunthoeun\",\"given_name\":\"thoeun\",\"family_name\":\"thoeun\",\"email\":\"thoeun@gmail.com\"}]";
		String jsonTest = " [{\"SITE_NM\":\"\",\"AVAILABLE_AMT\":\"\",\"GUEST_NM\":\"\",\"JBCL_NM\":\"\",\"DVSN_CD\":\"\",\"GUEST_ID\":\"simdemo01t\",\"JBCL_CD\":\"\",\"DVSN_NM\":\"심관리자s\"}]";
		String[] words  = new String[4];
		words[0]		= "ace";
		words[1]		= "boom";
		words[2]		= "crew";
		words[3]		= "thoeun";
		String bookingRoom = "[{\"checkin\":\"2020-04-28\",\"special_request\":\"Top floor or away from street please\",\"rate\":{\"cancel_refund\":{\"amount\":\"-65.98\",\"currency\":\"KRW\"},\"amenities\":[2192],\"merchant_of_record\":\"expedia\",\"nightly\":[[{\"currency\":\"KRW\",\"type\":\"tax_and_service_fee\",\"value\":\"27273\"},{\"currency\":\"KRW\",\"type\":\"base_rate\",\"value\":\"272727\"}],[{\"currency\":\"KRW\",\"type\":\"tax_and_service_fee\",\"value\":\"27273\"},{\"currency\":\"KRW\",\"type\":\"base_rate\",\"value\":\"272727\"}]],\"refundable\":false,\"id\":\"209362608\"},\"number_of_adults\":2,\"smoking\":false,\"confirmation_id\":{\"expedia\":\"488983906029046\"},\"links\":{\"cancel\":{\"method\":\"DELETE\",\"href\":\"/2.3/itineraries/7137232808488/rooms/a88d4e1a-4796-41e3-9c77-098e4508b87c?token=QFlCEVhQRmxHFg4EXVpVOlEBCFQACVEAVkBcVFRdDwUEWBxHR1AURgBUWw1OFl9XQEtWC0peEUdyUQdXWRVDXwkFAwIHAgADB1oC\"},\"change\":{\"method\":\"PUT\",\"href\":\"/2.3/itineraries/7137232808488/rooms/a88d4e1a-4796-41e3-9c77-098e4508b87c?token=QFlCEVhQRmxHFg4EXVpVOlEBCFQACVEAVkBcVFRdDwUEWBxHR1AURgBUWw1OFl9XQEtWC0peEUdyUQdXWRVDXwkFAwIHAgADB1oC\"}},\"id\":\"201846819\",\"given_name\":\"John\",\"checkout\":\"2020-04-30\",\"family_name\":\"Smith\",\"status\":\"booked\"}]";
		try {
			JSONArray jsonArr  = new JSONArray(jsonTest);
			System.out.println("JSON Length:: "+ jsonArr.length());
			
			for(int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				System.out.println(jsonObj.get("GUEST_ID"));
				
//				JSONObject phoneObj = new JSONObject(jsonObj.get("phone").toString());
//				System.out.println(phoneObj.get("country_code"));
			}
			for(int i = 0; i < words.length; i++) {
				System.out.println("words:: "+words[i]);
			}
			
			JSONArray jsonArrRoom  = new JSONArray(bookingRoom);
			System.out.println("JSON Length:: "+ jsonArrRoom.length());
			for(int i = 0; i < jsonArrRoom.length(); i++) {
				JSONObject jsonRoomObj	= jsonArrRoom.getJSONObject(i);
				JSONObject jsonArrItem  = new JSONObject(jsonRoomObj.get("links").toString());
				JSONObject arrLink	  	= new JSONObject(jsonArrItem.get("cancel").toString());
				String cancelLinkBooking = arrLink.get("href").toString();
//				JSONObject arrLink	  	= new JSONObject("{\"cancel\":{\"method\":\"DELETE\",\"href\":\"/2.3/itineraries/7137232808488/rooms/a88d4e1a-4796-41e3-9c77-098e4508b87c?token=QFlCEVhQRmxHFg4EXVpVOlEBCFQACVEAVkBcVFRdDwUEWBxHR1AURgBUWw1OFl9XQEtWC0peEUdyUQdXWRVDXwkFAwIHAgADB1oC\"},\"change\":{\"method\":\"PUT\",\"href\":\"/2.3/itineraries/7137232808488/rooms/a88d4e1a-4796-41e3-9c77-098e4508b87c?token=QFlCEVhQRmxHFg4EXVpVOlEBCFQACVEAVkBcVFRdDwUEWBxHR1AURgBUWw1OFl9XQEtWC0peEUdyUQdXWRVDXwkFAwIHAgADB1oC\"}}");
				System.out.println("jsonArrItem links:::: "+jsonRoomObj.get("links"));
				System.out.println("jsonArrItem arrLi:::: "+arrLink.get("href"));
				System.out.println("jsonArrItem jsonArrItem:::: "+jsonArrItem);
				System.out.println("==========");
			}
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
