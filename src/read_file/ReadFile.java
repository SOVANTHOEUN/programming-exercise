package read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		try {
//			Date today = new Date();
//			SimpleDateFormat fmt1	= new SimpleDateFormat("yyyy-MM-dd");
//			String CREATE_DATE		= fmt1.format(today);
//			File createFile = new File("C:\\FTC_downloads\\2021-07-14");
////			createFile.mkdir();
//			
//			File renameTo = new File("C:\\FTC_downloads\\2021-07-14_done");
//			
//			if(createFile.exists()) {
//				if (createFile.renameTo(renameTo)) {
//				    System.out.println("File renamed successfully");
//				} else {
//				    System.out.println("Failed to rename file");
//				}
//			}
			
//			File writeData = new File("C:\\FTC_downloads\\"+CREATE_DATE+"\\"+CREATE_DATE+"_1.csv");
//			FileWriter writer = null;
//			
//			try {
//				// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
//				writer = new FileWriter(writeData);
//				writer.write("CSV testing ~~~");
//	            writer.flush();
//	            System.out.println("testing done...");
//	        } catch(IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if(writer != null) writer.close();
//	            } catch(IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//			
//			System.out.println("count file: "+createFile.list().length);
//			Reader in = new BufferedReader(new FileReader(new File("C:\\FTC_downloads\\2021-07-14\\errPropId_1.txt")));
//			System.out.println("read data: "+in);
			
			
			Scanner deleteSql = new Scanner(new File("C:\\FTC_downloads\\2021-07-14\\errPropId_1.txt"));
			System.out.println("deleteSql: "+deleteSql.next());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
