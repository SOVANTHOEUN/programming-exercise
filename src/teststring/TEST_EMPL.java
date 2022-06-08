package teststring;

import org.json.JSONException;

public class TEST_EMPL {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		String strRoomGuest = "{\"ROOM_GUEST\":[{\"EMPLOYEE\":[{\"EMP_NO\":\"98101001\",\"FLNM\":\"\\uc2ec\\uad00\\ub9ac\\uc790s\",\"CLPH_NO\":\"01077778898\",\"JBCL_CD\":\"\",\"JBCL_NM\":\"\\uacfc\\uc7a5\",\"DVSN_NM\":\"\\uc0c1\\ud4881\\ubd80\",\"CLPH_NTNL_CD\":\"KR_82\",\"EML\":\"dfd@bizplay.co.kr\",\"USER_ID\":\"98101001\"}],\"OTHER\":{\"ADULT_CNT\":1,\"CHILDREN_CNT\":1,\"CHILDREN_AGE\":\"\"},\"OCCUPANCY\":\"occupancy=2\"},{\"EMPLOYEE\":[{\"EMP_NO\":\"20171121_006\",\"FLNM\":\"\\uc0dd\\uc0b0\\ud300\\uc7a5\",\"CLPH_NO\":\"01036451679\",\"RSPT_NM\":\"\",\"JBCL_CD\":\"\",\"JBCL_NM\":\"\\ud300\\uc7a5\",\"SITE_NM\":\"\\ube44\\ud50c\\ud14c\\uc2a4\\ud2b8\",\"DVSN_NM\":\"\\uc0dd\\uc0b0\\ud300\",\"CLPH_NTNL_CD\":\"KR_82\",\"EML\":\"sonhanky@naver.com\",\"USER_ID\":\"20171121_006\"}],\"OTHER\":{\"ADULT_CNT\":0,\"CHILDREN_CNT\":1,\"CHILDREN_AGE\":\"3\"},\"OCCUPANCY\":\"occupancy=1-3\"}]}";
//		String strRoomGuest = "[{\"EMPLOYEE\":[{\"EMP_NO\":\"98101001\",\"FLNM\":\"\\uc2ec\\uad00\\ub9ac\\uc790s\",\"CLPH_NO\":\"01077778898\",\"JBCL_CD\":\"\",\"JBCL_NM\":\"\\uacfc\\uc7a5\",\"DVSN_NM\":\"\\uc0c1\\ud4881\\ubd80\",\"CLPH_NTNL_CD\":\"KR_82\",\"EML\":\"dfd@bizplay.co.kr\",\"USER_ID\":\"98101001\"}],\"OTHER\":{\"ADULT_CNT\":1,\"CHILDREN_CNT\":2,\"CHILDREN_AGE\":\"4,9\"},\"OCCUPANCY\":\"occupancy=2\"},{\"EMPLOYEE\":[{\"EMP_NO\":\"20171121_006\",\"FLNM\":\"\\uc0dd\\uc0b0\\ud300\\uc7a5\",\"CLPH_NO\":\"01036451679\",\"RSPT_NM\":\"\",\"JBCL_CD\":\"\",\"JBCL_NM\":\"\\ud300\\uc7a5\",\"SITE_NM\":\"\\ube44\\ud50c\\ud14c\\uc2a4\\ud2b8\",\"DVSN_NM\":\"\\uc0dd\\uc0b0\\ud300\",\"CLPH_NTNL_CD\":\"KR_82\",\"EML\":\"sonhanky@naver.com\",\"USER_ID\":\"20171121_006\"}],\"OTHER\":{\"ADULT_CNT\":0,\"CHILDREN_CNT\":1,\"CHILDREN_AGE\":\"3\"},\"OCCUPANCY\":\"occupancy=1-3\"}]";
		org.json.JSONObject roomGuestObj0 = new org.json.JSONObject(strRoomGuest);
//		System.out.println("roomGuestObj0: "+roomGuestObj0.get("ROOM_GUEST"));
		org.json.JSONArray roomGuestArr  = new org.json.JSONArray(roomGuestObj0.get("ROOM_GUEST").toString());
		System.out.println("roomGuestArr:"+roomGuestArr);
		/*for(int i = 0;i < 2;i++) {
			org.json.JSONObject roomGuestObj = roomGuestArr.getJSONObject(i);
			org.json.JSONArray roomGuestEmplArr  = new org.json.JSONArray(roomGuestObj.get("EMPLOYEE").toString());
			org.json.JSONObject roomGuestOtherArr = new org.json.JSONObject(roomGuestObj.get("OTHER").toString());
			String countAdults	= roomGuestOtherArr.get("ADULT_CNT").toString();
			String countChild	= roomGuestOtherArr.get("CHILDREN_CNT").toString();
			String childAgesArr	= roomGuestOtherArr.get("CHILDREN_AGE").toString();
			String token1[] = childAgesArr.split(",");
//			String childAges = token1[i];
			
			System.out.println("test room roomGuestEmplArr"+(i+1)+": "+roomGuestEmplArr);
			System.out.println("test room countAdults"+(i+1)+": "+countAdults);
			System.out.println("test room countChild"+(i+1)+": "+countChild);
			
//			for(int j = 0;j < roomGuestEmplArr.length(); j++) {
//				org.json.JSONObject roomEmplObj = roomGuestEmplArr.getJSONObject(j);
//				System.out.println("employee guest object"+(j+1)+": "+roomEmplObj.get("FLNM"));
//			}
			
			for(int j = 0;j < Integer.parseInt(countChild); j++) {
				System.out.println("test room childAges"+(j+1)+": "+token1[j]);
			}
		}*/
		
	}
}
