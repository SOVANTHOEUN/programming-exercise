package GeeksforGeeks_problem;

public class ReplaceAllZeroTo5 {
    public static void main(String[] args) {
        int n = 121;
        System.out.println(new ReplaceAllZeroTo5().convertFive(n));
    }

    public int convertFive(int n){
        int newNum = 0;
        String strNum = String.valueOf(n).replaceAll("0", "5");
        newNum = Integer.parseInt(strNum);
        return newNum;
    }
}
