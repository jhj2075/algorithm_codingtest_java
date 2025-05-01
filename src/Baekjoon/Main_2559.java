package Baekjoon;

import java.util.Scanner;


// 구간 합 - 수열
public class Main_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] S = new int[n];
        int[] ans = new int[n-k+1];

        arr[0] = sc.nextInt();
        S[0] = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();
            S[i] = S[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        ans[0] = S[k-1];
        max = Math.max(max, ans[0]);
        for (int i = 1; i < n - k + 1; i++) {
            ans[i] = S[i + k - 1] - S[i - 1];
            max = Math.max(max, ans[i]);
        }

        System.out.println(max);
    }
}
