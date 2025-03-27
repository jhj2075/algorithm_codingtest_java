package Baekjoon.Do_it;

import java.io.IOException;
import java.util.Scanner;


// 그래프 - 경로 찾기 (플로이드-워셜 알고리즘)
public class Main_62_11403 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] D = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = sc.nextInt();
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (D[s][k] == 1 && D[k][e] == 1)
                        D[s][e] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }
}
