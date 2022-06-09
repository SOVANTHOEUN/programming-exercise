package GeeksforGeeks_problem;

public class SumOfArray {
    public static void main(String[] args) throws Exception{
        int[] arr = {37, 61, 30, 28}; // 156
        int size = arr.length;
        int sumOfArr = new SumOfArray().getSum(arr, size);
        System.out.println(sumOfArr);
    }

    public int getSum(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }
}
