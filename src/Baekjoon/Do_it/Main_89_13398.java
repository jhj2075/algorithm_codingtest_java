package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 연속된 정수의 합 구하기
public class Main_89_13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 좌측에서부터 구간의 최대합을 구함
        int[] L = new int[n];
        L[0] = arr[0];
        int ans = L[0];
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(arr[i], L[i-1] + arr[i]);
            ans = Math.max(ans, L[i]); // 일단 이 구간합 중 최대인 것을 결과로
        }

        // 우측에서부터 구간의 최대합을 구함
        int[] R = new int[n];
        R[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            R[i] = Math.max(arr[i], R[i+1] + arr[i]);
        }

        // 한 칸을 빼는 경우, 그 칸의 좌측 구간합과 우측 구간합을 더하는 방식으로 구함
        for (int i = 1; i < n-1; i++) {
            ans = Math.max(ans, L[i-1] + R[i+1]); // 한 칸을 뺐을 때 최대가 나오는 경우 그걸 결과로
        }

        System.out.println(ans);

    }
}
