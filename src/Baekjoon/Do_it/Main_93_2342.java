package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - ddr을 해보자
public class Main_93_2342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // D[n][l][r] => n개의 수열을 수행한 후 왼발 위치가 l, 오른발 위치가 r일 때의 누적 힘의 최소
        int[][][] D = new int[100001][5][5];
        // mp[i][j] => i에서 j로 갈 때 드는 힘
        int[][] mp = {{0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    D[k][i][j] = 100001 * 4;
                }
            }
        }
        D[0][0][0] = 0;
        int n = 0;
        int s = 1;
        while (true){
            n = sc.nextInt();
            if (n == 0)
                break;

            // 오른발이 이동한 경우
            for (int i = 0; i < 5; i++) {
                if (n == i)
                    continue; // 오른발과 왼발이 같은 칸에 놓일 수는 없음
                for (int j = 0; j < 5; j++) {
                    // 이전 수열에 오른발을 n으로 옮기는 힘을 더한 값과 현재 있는 값 중 최솟값
                    // (왼발의 이동으로 인해 D 배열이 변할 수 있으므로, 이 코드에서는 오른발 먼저하고 왼발 하긴 하지만.)
                    D[s][i][n] = Math.min(D[s-1][i][j] + mp[j][n], D[s][i][n]);
                }
            }

            // 왼발이 이동한 경우
            for (int j = 0; j < 5; j++) {
                if (j == n)
                    continue;
                for (int i = 0; i < 5; i++) {
                    // 이전 수열에 왼발을 n으로 옮기는 힘을 더한 값과 현재 있는 값 중 최솟값
                    D[s][n][j] = Math.min(D[s-1][i][j] + mp[i][n], D[s][n][j]);
                }
            }

            s++;
        }
        s--;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, D[s][i][j]);
            }
        }
        System.out.println(min);
    }
}
