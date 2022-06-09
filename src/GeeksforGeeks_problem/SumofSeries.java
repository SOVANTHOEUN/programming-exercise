package GeeksforGeeks_problem;

import java.math.BigInteger;
import java.util.Arrays;

public class SumofSeries {
    public static void main(String[] args){
        int n = 46341;
//        int sum = (46341 * (46341 + 1)) / 2; // 1,073,767,311
        System.out.println("getSum3 : "+new SumofSeries().getSum3(n));
    }

    public int getSum1(int n){
        int sum = 0;
        for(int i=1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public BigInteger getSum2(int n){
//        (n * (n + 1)) / 2
        BigInteger n1 = BigInteger.valueOf(n);
        BigInteger n2 = n1.add(BigInteger.valueOf(1));
        BigInteger n3 = n1.multiply(n2);
        BigInteger n4 = n3.divide(BigInteger.valueOf(2));
        return n4;
    }

    // best choice
    public long getSum3(int n){
        return ((long)n * ((long)n + 1)) / 2;
    }


}
