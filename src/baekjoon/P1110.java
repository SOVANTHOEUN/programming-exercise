package baekjoon;

import java.util.Scanner;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers;

public class P1110 {
	public static int countNum = 0;
	public static String oriStr = "";
	public static void main(String[] args) {
		Scanner input	= new Scanner(System.in);
		String  inStr	= input.nextLine();
				oriStr	= inStr;
		if(Integer.parseInt(inStr) >= 0 && Integer.parseInt(inStr) <= 99) {
			if(factorial(inStr, 0) == 0) {
				System.out.println(countNum);
			}
		}
	}
	
	static int factorial(String numStr, int sumNum) {
		countNum++;
		int newSum = 0;
		String newStr = "";
		String chkStr = "";
		if(numStr.length() < 2) {
			numStr = "0" + numStr;
		}
		
		if(sumNum == 0) {
			newSum = Integer.parseInt(numStr.split("")[0]) + Integer.parseInt(numStr.split("")[1]);
			newStr = numStr;
			chkStr = String.valueOf(newSum);
		}else {
			newStr = String.valueOf(sumNum);
			if(String.valueOf(sumNum).length() == 2) {
				newSum = Integer.parseInt(numStr.split("")[1]) + Integer.parseInt(String.valueOf(sumNum).split("")[1]);
				chkStr = numStr.split("")[1] + String.valueOf(sumNum).split("")[1];
			}else {
				newSum = Integer.parseInt(numStr.split("")[1]) + sumNum;
				chkStr = numStr.split("")[1] + String.valueOf(sumNum);
			}
		}
		
		if(String.valueOf(newSum).length() == 2) {
			if(newStr.length() == 2) {
				chkStr = newStr.split("")[1] + String.valueOf(newSum).split("")[1];
			}else {
				chkStr = newStr + String.valueOf(newSum).split("")[1];
			}
		}else {
			if(newStr.length() == 2) {
				chkStr = newStr.split("")[1] + String.valueOf(newSum);
			}else {
				chkStr = newStr + String.valueOf(newSum);
			}
		}
		System.out.println("newStr: "+newStr+" || newSum: "+newSum+" --> "+chkStr+" "+chkStr+" total: "+countNum);
		if(Integer.parseInt(oriStr) == Integer.parseInt(chkStr)) {
			return 0;
		}else{
			return factorial(newStr, newSum);
		}
	}
	
}
