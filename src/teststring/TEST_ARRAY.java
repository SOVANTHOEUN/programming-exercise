package teststring;

import org.json.JSONArray;

public class TEST_ARRAY {
	private static final int[]  COUNTRY_CODE = {1,2,3,5,6,6,6};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp = 0;
		for(int i=0 ;i< COUNTRY_CODE.length ;i++) {
			for(int j=i+1 ; j<COUNTRY_CODE.length-1; j++) {
			     if(COUNTRY_CODE[i] > COUNTRY_CODE[j] ){
			          tmp = COUNTRY_CODE[i];
			          COUNTRY_CODE[i] = COUNTRY_CODE[j];
	        		  COUNTRY_CODE[j] = tmp;
			     }
			}
		}
		System.out.println(COUNTRY_CODE[0]);
	}
}
