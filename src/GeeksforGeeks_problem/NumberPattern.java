package GeeksforGeeks_problem;

import javax.swing.text.Style;
import java.util.Scanner;

public class NumberPattern {
    public static void main(String[] args){
        System.out.print("number pattern, input pls: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NumberPattern obj = new NumberPattern();
        obj.getPattern1(n, n);
    }

    public void getPattern1(int n, int m){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int num = m-i;
                System.out.print(num);
                if(i == m-1 && j == n-1){
                    System.out.print("$");
//                    System.out.println();
                    NumberPattern obj = new NumberPattern();
                    obj.getPattern1(n-1, m);
                }
            }
        }
    }
}
