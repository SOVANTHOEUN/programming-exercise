package baekjoon;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int origin = Integer.parseInt(br.readLine());
        int tmp1 = origin, tmp2 = 0;
        int count = 0;

        while (true) {
            count++;
            int ten = tmp1 / 10;
            int one = tmp1 % 10;

            tmp2 = one * 10 + (one + ten) % 10;
            System.out.println("tmp2: "+tmp2);
            if (origin == tmp2) {
                break;
            }
            tmp1 = tmp2;
        }
        System.out.println(count);
    }
}