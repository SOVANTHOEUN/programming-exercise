package GeeksforGeeks_problem;

import java.util.Arrays;

public class CyclicallyRotateArray {
    public static void main(String[] args) {
        int[] a = {1,2};
        int n = a.length;
        int lastV = a[n-1];
        int newArr[] = new int[n];
        newArr[0] = lastV;

        for(int i=0; i<n-1; i++){
            newArr[i+1] = a[i];
        }

        System.out.println("old array: "+ Arrays.toString(a));
        System.out.println("new array: "+ Arrays.toString(newArr));
    }
}
