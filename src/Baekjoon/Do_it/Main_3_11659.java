package Baekjoon.Do_it;

import java.util.Scanner;


// 구간 합 - 구간 합 구하기
public class Main_3_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N+1];
        int[] S = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i < N+1; i++) {
            S[i] = S[i-1] + A[i];
        }

        for (int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(S[b] - S[a-1]);
        }
    }
}
