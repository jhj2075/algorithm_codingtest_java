package Baekjoon;

import java.util.Scanner;

public class Main_3226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;
        for (int i = 0; i < N; i++) {
            String callTime = sc.next();
            int t = sc.nextInt();
            String[] time = callTime.split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int hm = h * 60 + m;

            if (hm < 420 && hm + t >= 420){
                result += (420 - hm) * 5;
                result += (hm + t - 420) * 10;
            } else if (hm < 19 * 60 && hm + t >= 19 * 60){
                result += (19 * 60 - hm) * 10;
                result += (hm + t - 19 * 60) * 5;
            } else if (hm >= 420 && hm < 19 * 60){
                result += t * 10;
            } else {
                result += t * 5;
            }
        }
        System.out.println(result);
    }
}
