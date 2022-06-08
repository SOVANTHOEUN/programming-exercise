package baekjoon;

import java.util.*;
import java.util.Map.Entry;
public class P1157 {
	public static char printMaxOccurringChar(String inputString){
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		char[] charArray = inputString.toLowerCase().replaceAll("\\s+", "").toCharArray();
		for (char c : charArray){
			if (charCountMap.containsKey(c)){
				charCountMap.put(c, charCountMap.get(c)+1);
			}else{
				charCountMap.put(c, 1);
			}
		}
		
		Set<Entry<Character, Integer>> entrySet = charCountMap.entrySet();
		int maxCount = 0;
		char maxChar = 0;
		for (Entry<Character, Integer> entry : entrySet){
			if (entry.getValue() == maxCount){
				maxCount = entry.getValue();
				maxChar  = '?';
			}else if (entry.getValue() > maxCount){
				maxCount = entry.getValue();
				maxChar  = entry.getKey();
			}
		}
		return maxChar;
	}
	public static void main(String[] args) throws Exception{
		/*Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine().toLowerCase();
		char output   = printMaxOccurringChar(inputStr);
		
		System.out.println(Character.toUpperCase(output));
		input.close();*/
		
		int b[] = new int[26];
		int c   = System.in.read();
		while(c > 13) {
			System.out.println("System in read:: "+c);
			if(c > 64 && c < 123) {
				if(c < 91) {
					b[c-65]++; // upper alphabet
				} else {
					b[c-97]++; // lower alphabet
				}
			}
			c = System.in.read();
		}
		
		/*int max  = -1;
		int maxN = 0;
		for(int i = 0; i < b.length; i++) {
			if(b[i] > max) {
				max  = b[i];
				maxN = i;
			} else if(b[i] == max) {
				maxN = -2;
			}
		}
		System.out.println((char)(maxN+65));*/
	}
}


/*
 * 
 *  id : 1701592
 *  int b[] = new int[26];
	int c   = System.in.read();
	while(c > 13) {
		if(c > 64 && c < 123) {
			if(c < 91) {
				b[c-65]++; // upper alphabet
			} else {
				b[c-97]++; // lower alphabet
			}
		}
		c = System.in.read();
	}
	
	int max  = -1;
	int maxN = 0;
	for(int i = 0; i < b.length; i++) {
		if(b[i] > max) {
			max  = b[i];
			maxN = i;
		} else if(b[i] == max) {
			maxN = -2;
		}
	}
	System.out.println((char)(maxN+65));
 *  */
