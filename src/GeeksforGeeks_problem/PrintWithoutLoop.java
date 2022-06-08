package GeeksforGeeks_problem;

import java.util.Scanner;

public class PrintWithoutLoop {
    public static void main(String[] args){
        System.out.print("input number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintWithoutLoop obj = new PrintWithoutLoop();
        obj.noLoop(n, 0);
    }

    public void noLoop(int n, int count){
        if(count < n){
            System.out.print((count + 1)+" ");
            PrintWithoutLoop obj = new PrintWithoutLoop();
            obj.noLoop(n, count+1);
        }
    }
}
