package GeeksforGeeks_problem;

import java.util.*;

public class SecondLargestArr {
    public static void main(String[] args) throws Exception{
        // multiple test case
//        int[] arr = {999, 668, 757, 227, 78, 1, 494, 758, 2002, 2500, 3000, 867, 148, 1000, 1000, 1002, 323, 911, 1000};
//        int[] arr = {37, 61, 30, 28, 47, 42, 25, 41, 56, 27, 45, 44, 34, 46, 35, 58, 36, 60, 29, 53, 55, 32, 31, 33, 59, 50, 51, 52, 37, 39, 38, 43, 49, 54, 57, 40, 26, 48};
        // mehtod2 method3 error
//        int[] arr = {642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642, 642};
        // method2 error
        int[] arr = {42, 28, 43, 26, 65, 60, 54, 51, 35, 42, 48, 33, 40, 58, 38, 64, 47, 44, 49, 46, 25, 57, 39, 55, 45, 29, 32, 61, 53, 31, 36, 56, 63, 30, 52, 27, 34, 50, 41, 37, 66, 62, 59};
        int n = arr.length;
        int ans = new SecondLargestArr().print2largest1(arr, n);
        System.out.println(ans);
    }

    // match for every test case
    public int print2largest1(int[] arr, int n){
        int second = 0;
        if(n > 2){
            Arrays.sort(arr);
            for(int i = n-2; i >= 0; i-- ){
                if(arr[i] != arr[n - 1]){
                    second = arr[i];
                    break;
                }else{
                    second = -1;
                }
            }
        }else{
            second = -1;
        }
        return second;
    }

    public int print2largest2(int[] arr, int n){
        int first = arr[0];
        int second = arr[0];
        if(n > 2){
            for(int i = 1; i < n; i++){
                first = Math.max(first, arr[i]);
            }

            for(int i = 0; i < n; i++){
                if (arr[i] != first){
                    second = Math.max(second, arr[i]);
                }
            }
        }else{
            second = -1;
        }
        return second;
    }

    public int print2largest3(int[] arr, int n){
        int first = arr[0];
        int second = arr[0];
        if(n > 2){
            for(int i = 1; i < n; i++){
                if(arr[i] > first){
                    second = first;
                    first  = arr[i];
                }else if(arr[i] > second && arr[i] != first){
                    second = arr[i];
                }
            }
        }else{
            second = -1;
        }
        return second;
    }

    public int[] sortArray(int[] arr, int n){
        int temp = 0;
        if(n > 1){
            for(int i = 0;i < n; i++){
                for(int j = i + 1;j < n; j++){
                    if(arr[i] < arr[j]){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }
}
