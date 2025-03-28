package Baekjoon.Do_it;

import java.util.Scanner;


// 그래프 - 케빈 베이컨의 6단계 법칙 (플로이드-워셜 알고리즘)
public class Main_63_1389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] D = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    D[i][j] = 0;
                else
                    D[i][j] = 5001;
            }
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            D[s][e] = 1;
            D[e][s] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
                }
            }
        }
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i] += D[i][j];
            }
        }
        int min = 5001;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, result[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
}
