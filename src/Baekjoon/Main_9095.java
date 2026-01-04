package Baekjoon;

import java.util.Scanner;


// DP - 1, 2, 3 더하기
public class Main_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 4 이상일 때의 경우의 수 = (전거에서 + 1 한 경우) + (전전거에서 + 2 한 경우) + (전전전거에서 + 3 한 경우)
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}