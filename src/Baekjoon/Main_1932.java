package Baekjoon;

import java.util.Scanner;


// DP - 정수 삼각형
public class Main_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = arr[1][1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + arr[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + arr[i+1][j+1], dp[i+1][j+1]);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}