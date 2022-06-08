package baekjoon;

import java.util.Scanner;

public class P1152 {
	static int wordcount(String string){
		int count = 0;
		char ch[] = new char[string.length()];
		for(int i = 0;i < string.length();i++){
			ch[i] = string.charAt(i);
			if(((i > 0) && (ch[i] != ' ') && (ch[i-1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		System.out.println(wordcount(inputStr));
		input.close();
	}
}


/*
 * 
 *  id : newidextendsid
 *  import java.util.*;
	import java.io.*;
	
	public class Main {
		public static void main(String[] args) throws IOException {
			int count   = 0;
			int pre_str = 32;
			int str;
			
			while (true) {
				str = System.in.read();
				if (str == 32) {
					if (pre_str != 32) count++;
				}
				if (str == 10) {
					if (pre_str != 32) count++;
					break;
				}
				pre_str = str;
			}
			System.out.println(count);
			
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			System.out.println(st.countTokens());
//			br.close();
		}
	}
 *  */
