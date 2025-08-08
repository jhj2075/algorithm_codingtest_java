package Baekjoon;

import java.util.Scanner;

// 그래프 - 회장뽑기 (플로이드 - 워셜)
public class Main_2660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] D = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    D[i][j] = 0;
                else
                    D[i][j] = 100;
            }
        }
        while (true) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (s == -1 && e == -1)
                break;

            D[s][e] = 1;
            D[e][s] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (D[s][e] > D[s][k] + D[k][e])
                        D[s][e] = D[s][k] + D[k][e];
                }
            }
        }

        int max;
        int[] score = new int[N+1];
        for (int i = 1; i <= N; i++) {
            max = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                max = Math.max(max, D[i][j]);
            }
            score[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, score[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (score[i] == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);

        for (int i = 1; i <= N; i++) {
            if (score[i] == min)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
