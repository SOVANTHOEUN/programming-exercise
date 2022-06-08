package GeeksforGeeks_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayAlternative {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // System.out.println(((Object)br.readLine().trim()).getClass().getName());

        while(t --> 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();

                ArrayAlternative obj = new ArrayAlternative();
                obj.print(arr, n);
                System.out.println();
            }
        }

//        List<Integer> intList = new ArrayList<Integer>();
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        while (!str.isEmpty()) {
//            if(str.indexOf(" ") > -1){
//                for(int i = 0;i < str.split(" ").length;i++){
//                    int intEle = Integer.parseInt(str.split(" ")[i]);
//                    intList.add(intEle);
//                }
//            }else{
//                intList.add(Integer.parseInt(str));
//            }
//            str = br.readLine();
//        }
//
//        int[] ret = new int[intList.size()];
//        Iterator<Integer> iterator = intList.iterator();
//        for (int i = 0; i < ret.length; i++){
//            ret[i] = iterator.next().intValue();
//            if(i % 2 == 0){
//                System.out.print(ret[i] +" ");
//            }
//        }
    }

    public void print(int arr[], int n)
    {
        // your code
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
