package baekjoon;

import java.util.Scanner;

public class P2908 {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String str   = read.nextLine();
		String reverse = "";
		
		for(int i = str.length() - 1; i >= 0; i--){
			reverse = reverse + str.charAt(i);
		}
		
		String[] array = reverse.split(" ");
		String temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (Integer.parseInt(array[j]) < Integer.parseInt(array [j - 1])) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		
		System.out.println(array[array.length - 1]);
	}
}
