package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 계단 수 구하기
public class Main_88_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // D[i][j]는 길이가 i인데, j로 끝나는 계단 수인 경우의 수
        int[][] D = new int[n+1][10];
        for (int i = 1; i < 10; i++) {
            D[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0){
                    D[i][j] = D[i-1][j+1] % 1_000_000_000;
                }
                else if (j == 9) {
                    D[i][j] = D[i-1][j-1] % 1_000_000_000;
                }
                else {
                    D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1_000_000_000;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + D[n][i]) % 1_000_000_000;
        }
        System.out.println(sum);
    }
}
