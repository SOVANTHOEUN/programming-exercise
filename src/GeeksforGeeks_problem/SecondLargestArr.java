package GeeksforGeeks_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondLargestArr {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println(br.readLine().trim().toString());

//        int tc = Integer.parseInt(br.readLine().trim());
//        while (tc -- > 0){
//            String[] inputLine;
//            int n = Integer.parseInt (br.readLine().trim());
//            int[] arr = new int[n];
//            inputLine = br.readLine ().trim().split(" ");
//            for (int i = 0; i<n; i++){
//                arr[i] = Integer.parseInt (inputLine[i]);
//            }
//            int ans = new SecondLargestArr ().print2largest (arr, n);
//            System.out.println(ans);
//        }
    }

    public int print2largest(int[] arr, int n){
//        int n = 5;
//        int[] arr = {15, 2, 45, 12, 7};
        int secLargest = 0;
        Arrays.sort(arr);
        if(n > 1){
            secLargest = arr[arr.length - 2];
        }else{
            secLargest = -1;
        }
        return secLargest;
    }
}
