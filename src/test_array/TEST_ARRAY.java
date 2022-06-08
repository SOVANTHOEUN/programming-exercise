package test_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import jex.json.JSONArray;
import jex.json.JSONObject;

public class TEST_ARRAY {
	int maxnum   	= 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String amtGrp = "AP015|AP001|AP014|AP016|AP009|AP024";
		String amtId = "0020005|0020027|0020029|0020038|0020045|0020046";
//		String amtNm = "[{\"code\":null,\"name\":\"레스토랑\"},{\"code\":null,\"name\":\"와이파이\"},{\"code\":null,\"name\":\"욕실용품\"},{\"code\":null,\"name\":\"미니바\"},{\"code\":null,\"name\":\"조식포함\"},{\"code\":null,\"name\":\"금연\"},{\"code\":null,\"name\":\"무료주차\"},{\"code\":null,\"name\":\"TV\"}]";
		String amtNm = "[{\"code\":null,\"name\":\"레스토랑\"},{\"code\":null,\"name\":\"와이파이\"},{\"code\":null,\"name\":\"욕실용품\"},{\"code\":null,\"name\":\"미니바\"},{\"code\":null,\"name\":\"금연\"},{\"code\":null,\"name\":\"무료주차\"},{\"code\":null,\"name\":\"라운지\"},{\"code\":null,\"name\":\"세미나실\"},{\"code\":null,\"name\":\"TV\"},{\"code\":null,\"name\":\"장애인편의시설\"}]";
		
		JSONArray amenities  = new JSONArray();
		String amtNms[]  = amtNm.split("\\|");
		
		System.out.println("amtNms:: "+amtNms[1]);
		System.out.println("amenities: "+amenities);*/
		
		ArrayList<Integer> maxnums = new ArrayList();
		maxnums.add(Integer.parseInt("0"));
		int max = (int) Collections.max(maxnums);
		System.out.println("max: "+max);
		
		
//		System.out.println("New Test: "+Arrays.toString(get(
//			new int[] {1, 4, 3, 7, 2},
//			7
//		)));
	}
	
	static int[] get(int[] nums, int wanted) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == wanted) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}

}
