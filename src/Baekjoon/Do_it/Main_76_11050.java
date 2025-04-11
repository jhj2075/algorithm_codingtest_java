package Baekjoon.Do_it;

import java.util.Scanner;


// 조합 - 이항계수 구하기 1
public class Main_76_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] D = new int[n+1][k+1];
        if (k < 0 || n < k)
            System.out.println(0);
        else {
            // D 배열 초기화
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if (j == 0 || i == j){
                        D[i][j] = 1;
                    } else if (j == 1) {
                        D[i][j] = i;
                    }
                }
            }
            // 점화식 => D[i][j] = D[i-1][j] + D[i-1][j-1]
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    D[i][j] = D[i-1][j] + D[i-1][j-1];
                }
            }
            System.out.println(D[n][k]);
        }
    }
}
