package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 가장 큰 정사각형 찾기
public class Main_91_1915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] arr = new long[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Long.parseLong(String.valueOf(line.charAt(j-1)));
            }
        }

        // D[i][j] => 현재 위치가 정사각형의 오른쪽 아래 꼭짓점이라고 가정했을 때 그릴 수 있는 정사각형의 변의 길이
        int[][] D = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans = Math.max(ans, D[i][j]);
            }
        }
        System.out.println(ans * ans);
    }
}
