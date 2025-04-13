package Baekjoon.Do_it;

import java.util.Scanner;


// 조합 - 다리 놓기
public class Main_79_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            // mCn 을 구하면 되는 문제
            int[][] D = new int[m+1][n+1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (k == 0 || j == k)
                        D[j][k] = 1;
                    else if (k == 1) {
                        D[j][k] = j;
                    }
                }
            }
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    D[j][k] = D[j-1][k] + D[j-1][k-1];
                }
            }
            System.out.println(D[m][n]);
        }
    }
}
