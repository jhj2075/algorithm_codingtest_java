package Baekjoon.Do_it;

import java.util.Scanner;


// 조합 - 부녀회장이 될 테야
public class Main_78_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] D = new int[k+1][n+1];
            for (int j = 0; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    if (j == 0){
                        D[j][l] = l;
                    }
                    else {
                        D[j][l] = D[j-1][l] + D[j][l-1];
                    }
                }
            }
            System.out.println(D[k][n]);
        }
    }
}
