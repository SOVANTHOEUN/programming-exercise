package testsubstring;

public class SubString {

	public static void main(String[] args) {
		String location = "오포 읍";
		String lastStr  = location.substring(location.length() - 1, location.length());
		String newStr   = location.substring(0, location.length() - 1);
		
		if(location.lastIndexOf("읍") > 0) {
			System.out.println("check "+ newStr.trim());
		}
		
		
		System.out.println("lastStr: "+lastStr.trim());
		System.out.println("newStr: "+newStr.trim());
		
	}

}
