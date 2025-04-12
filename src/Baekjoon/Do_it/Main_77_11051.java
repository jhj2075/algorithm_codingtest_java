package Baekjoon.Do_it;

import java.util.Scanner;

// 조합 - 이항계수 구하기 2
public class Main_77_11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] D = new int[n+1][k+1];
        // D 배열 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 1){
                    D[i][j] = i;
                }
                else if (j == 0 || i == j){
                    D[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                D[i][j] = (D[i-1][j-1] + D[i-1][j]) % 10_007;
            }
        }
        System.out.println(D[n][k]);
    }
}
