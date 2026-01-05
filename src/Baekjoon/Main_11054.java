package Baekjoon;

import java.util.Scanner;


// DP - 가장 긴 바이토닉 부분 수열
public class Main_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순과 내림차순 배열을 합쳐서 -1 해주면 됨
        int[] asc_dp = new int[n];
        for (int i = 0; i < n; i++) {
            asc_dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && asc_dp[i] < asc_dp[j] + 1)
                    asc_dp[i] = asc_dp[j] + 1;
            }
        }

        int[] desc_dp = new int[n];
        for (int i = n-1; i >= 0; i--) {
            desc_dp[i] = 1;

            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && desc_dp[i] < desc_dp[j] + 1)
                    desc_dp[i] = desc_dp[j] + 1;
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = asc_dp[i] + desc_dp[i] - 1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
