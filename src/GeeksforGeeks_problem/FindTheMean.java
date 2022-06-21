package GeeksforGeeks_problem;

import java.util.Arrays;

public class FindTheMean {
    public static void main(String[] args) {
        double[] lattArr = {37.489541,37.504866,37.508976,37.510910,37.515396,37.527800,37.540875,37.542809,37.555708,37.555955,37.558496,37.559840,37.559910,37.560190,37.561070,37.562155,37.562369,37.562426,37.563995,37.564111,37.564250,37.564310,37.564850,37.565328,37.566081,37.566330,37.568240,37.572724,37.574475,37.589261};
        double[] longArr = {126.917500,126.934648,126.948120,126.951977,126.966992,126.969377,126.974026,126.977220,126.978050,126.978598,126.979500,126.979555,126.980835,126.980844,126.983623,126.984792,126.985610,126.985690,126.988080,126.990879,126.995810,127.002890,127.004330,127.029712,127.041735,127.057428,127.057760,127.059892,127.110853,127.111155};

        System.out.println("latt & long mean : "+new FindTheMean().getMean(lattArr, lattArr.length) +", "+ new FindTheMean().getMean(longArr, longArr.length));
    }

    public double getMean(double[] arr, int n){
        double mean = 0;
        double sum  = 0;
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        mean = sum / n;
        return mean;
    }
}
