package GeeksforGeeks_problem;

import java.util.Arrays;

public class FindTheMedian {
    public static void main(String[] args){
        int[] arr = {90, 100, 78, 89, 67};
        int n = arr.length;
        int getMedian = new FindTheMedian().getMedian(arr, n);
        System.out.println("this median value: "+ getMedian);
    }

    public int getMedian(int[] arr, int n){
        int median = 0;
        Arrays.sort(arr);

        if(n%2 == 0){
            int k = arr[(n / 2) - 1];
            int l = arr[(n / 2)];
            median = (k + l) / 2;
        }else{
            median = arr[(n + 1) / 2 - 1];
        }

        return median;
    }
}
