package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P11720 {
	public static void main (String[] args) throws IOException {
		Scanner input  = new Scanner(System.in);
		String numStr0 = input.nextLine();
		String numStr  = input.nextLine();
		int	   strLng  = numStr.length();
		int    output  = 0;
		
		for(int i = 0; i < strLng; i++) {
			output += Integer.parseInt(numStr.substring(i, i+1));
		}
		System.out.println(output);
		
		/*
		 * id : qkrgks456
		 *  */
		/*BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum  = 0;
		String a = bf.readLine();  // create first line
		String b = bf.readLine();
		String[] arr = b.split("");
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();*/
	}
}
