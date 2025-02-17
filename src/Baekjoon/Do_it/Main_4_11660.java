package Baekjoon.Do_it;

import java.util.Scanner;

// 구간 합 - 구간 합 구하기2
public class Main_4_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N+1][N+1];

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                A[i][j] = sc.nextInt();
            }
        }

        int[][] D = new int[N+1][N+1];
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]);
        }
    }
}
