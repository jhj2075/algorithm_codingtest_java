package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 빌딩 순서 구하기
public class Main_92_1328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        // D[n][l][r]은 빌딩 갯수가 n개이고 왼쪽에서 l개 오른쪽에서 r개 보일 때의 경우의 수
        long[][][] D = new long[n+1][l+1][r+1];
        D[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    D[i][j][k] = (D[i-1][j-1][k] + D[i-1][j][k-1] + D[i-1][j][k] * (i-2)) % 1000000007;
                }
            }
        }
        System.out.println(D[n][l][r]);
    }
}
